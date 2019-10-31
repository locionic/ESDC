/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myejb7test;

import edu.tdt.entity.SystemManagement;
import edu.tdt.entity.SystemManagementRemote;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author truonghongloc
 */
public class MyEJB7Test {

    private Properties props;
    private InitialContext ctx;
    public MyEJB7Test()
    {
    readJNDI();
    }
    /**
    * Read the JNDI properties file
    */
    private void readJNDI()
    {
    props = new Properties();
    try
    {
    props.load(new FileInputStream("jndi.properties"));
    } catch(IOException e)
    {
    e.getMessage();
    }
    try
    {
    ctx = new InitialContext(props);
    } catch (NamingException ex)
    {
    ex.getMessage();
    }
    }
    /**
    * Construct and return the JNDI address of called class
    * @return String
    */
    private String getJNDI()
    {
    String appName = "";
    String moduleName = "MyEJB7";
    String distinctName = "";
    String sessionBeanName = SystemManagement.class.getSimpleName();
    String viewClassName = SystemManagementRemote.class.getName() + "?stateful";
    return "ejb:"+appName+"/"+moduleName+"/"+distinctName+"/"+sessionBeanName+"!"+viewClassName;
    }
    /**
    * Show the GUI in console window
    */
    private void showGUI()
    {
    System.out.println("\n=========================");
    System.out.println("TDT System Management");
    System.out.println("=========================");
    System.out.print("Options: \n1. Add User \n2. Add Role \n3. Search Users by Role \n4. Exit \nEnter Choice: ");
    }
    /**
    * Test the Stateless EJB
    */
    public void testEntityEJB()
    {
    try
    {
    Scanner sc = new Scanner(System.in);
    // Lookup the SystemManagementRemote
    SystemManagementRemote session = (SystemManagementRemote) ctx.lookup(getJNDI());
    // Log-in
    String _username, _password;
    System.out.println("Log-in to TDT System Management");
    System.out.print("Username: ");
    _username = sc.nextLine();
    System.out.print("Password: ");
    _password = sc.nextLine();
    if(_password.hashCode() != session.getUserPassword(_username))
    {
    System.err.println("Wrong username/password!");
    return;
    }
    // Show GUI
    int choice;
    String username, password, rolename;
    do
    {
    showGUI();
    choice = Integer.parseInt(sc.nextLine());
    switch(choice)
    {
    case 1: // Insert new user with created role
    System.out.print("Enter username : ");
    username = sc.nextLine();
    System.out.print("Enter password : ");
    password = sc.nextLine();
    System.out.print("Enter role name : ");
    rolename = sc.nextLine();
    session.insertUser(username, password);
    session.insertUserRole(username, rolename);
    System.out.println("Done!");
    break;
    case 2: // Insert new role
    System.out.print("Enter role: ");
    rolename = sc.nextLine();
    session.insertRole(rolename);
    System.out.println("Done!");
    break;
    case 3: // Search user by role
    System.out.print("Enter role name: ");
    rolename = sc.nextLine();
    for(String s : session.searchRole(rolename))
    {
    System.out.println(s);
    }
    System.out.println("Done!");
    break;
    default:
    break;
    }
    } while(choice != 4);
    } catch (NamingException ex)
    {
    Logger.getLogger(MyEJB7Test.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
