/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myejb10test;

import edu.tdt.entity.Hanghoa;
import edu.tdt.entity.Hdhh;
import edu.tdt.entity.Hoadon;
import edu.tdt.entity.Nhacc;
import edu.tdt.entity.Nhanvien;
import edu.tdt.entity.Taikhoan;
import edu.tdt.entity.Vitri;
import edu.tdt.session.MySessionBean;
import edu.tdt.session.MySessionBeanRemote;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
public class MyEJB10Test {

    private Properties props;
    private InitialContext ctx;
    public MyEJB10Test()
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
    System.err.println(e.toString());
    }
    try
    {
    ctx = new InitialContext(props);
    //ctx.close();
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
    String moduleName = "MyEJB10";
    String distinctName = "";
    String sessionBeanName = MySessionBean.class.getSimpleName();
    String viewClassName = MySessionBeanRemote.class.getName() + "?stateful";
    return "ejb:"+appName+"/"+moduleName+"/"+distinctName+"/"+sessionBeanName+"!"+viewClassName;
    }
    /**
    * Show the GUI in console window
    */
    private void showGUI()
    {
    System.out.println("\n=========================");
    System.out.println("Welcome to TDTU Bookstore");
    System.out.println("=========================");
    System.out.print("\n1. Add nhanvien \n5. Add vitri \n6. Add taikhoan \n7. Add nhacc \n8. Add phieu \n9. Add hanghoa \n10. Add hoadon \n11. Add hdhh \n12. Add hhp \n4. Exit \nEnter Choice: ");
    }
    /**
    * Declare a bean to invoke getBooks() method in LibrarySessionBeanRemote
    */
    private void getAllBooks()
    {
    try
    {
    // We can define another bean to access the LibrarySessionBeanRemote
    MySessionBeanRemote libBean2 = (MySessionBeanRemote) ctx.lookup(getJNDI());
    List<Nhanvien> booksList = libBean2.getNhanvien();
    // Print all books
    if(booksList.isEmpty())
    {
    System.out.println("There is no book in the bookstore!\n");
    return;
    }
    System.out.println("\n=========================");
    System.out.println("Listing Books in TDTU Bookstore");
    System.out.println("=========================");
    for (int i = 0; i < booksList.size(); i++)
    {
    System.out.println((i+1) + "\t" + booksList.get(i));
    }
    System.out.println();
    } catch (NamingException ex)
    {
    ex.getMessage();
    }
    }
    /**
    * Test the Stateless EJB
    */
    public void testEntityEJB()
    {
    try
    {
    // Scanner definition
    Scanner sc = new Scanner(System.in);
    // Lookup the LibrarySessionBeanRemote
    MySessionBeanRemote libBean = (MySessionBeanRemote) ctx.lookup(getJNDI());
    int choice = 0;
    while(choice != 4)
    {
    this.showGUI();
    // Use this approach to avoid the error cause by nextInt() follows by nextLine()

    choice = Integer.parseInt(sc.nextLine());
    if(choice == 1)

    {
    // Add a book

    System.out.print("Enter nhanvien name: ");
    String _name = sc.nextLine();
    
    System.out.print("Enter nhanvien phone: ");
    String _phone = sc.nextLine();
    
    System.out.print("Enter nhanvien address: ");
    String _address = sc.nextLine();

    Nhanvien b = new Nhanvien();
    b.setName(_name);
    b.setAddress(_address);
    b.setPhone(_phone);
    
    libBean.addObject(b);
    }

    else if(choice == 2)

    {
    // Print all books (using current session bean)
    List<Nhanvien> booksList = libBean.getNhanvien();
    if(booksList.isEmpty())

    {
    System.out.println("There is no book in the bookstore!\n");
    }

    System.out.println("\n=========================");
    System.out.println("Listing Books in TDTU Bookstore");
    System.out.println("=========================");
    for (int i = 0; i < booksList.size(); i++)
    {
    System.out.println((i+1) + "\t" + booksList.get(i));
    }

    System.out.println();

    }
    else if(choice == 3)
    {
    // Print all books (using new session bean)

    getAllBooks();

    }
    else if(choice == 4)
    {
    // Exit
    break;
    }
    else if(choice == 5) {
        
        System.out.print("Enter vitri name: ");
        String _name = sc.nextLine();

        

        Vitri b = new Vitri();
        
        b.setName(_name);

        libBean.addObject(b);
        
    } else if(choice == 6) {
        
        System.out.print("Enter taikhoan name: ");
        String _name = sc.nextLine();
        
        System.out.print("Enter taikhoan password: ");
        String _password = sc.nextLine();
        
        System.out.print("Enter taikhoan id_nv: ");
        String _idnv = sc.nextLine();
        
        System.out.print("Enter taikhoan id_vt: ");
        String _idvt = sc.nextLine();

        

        

        libBean.addTaikhoan(_name, _password, Long.parseLong(_idnv), Long.parseLong(_idvt));
        
    } else if(choice == 7) {
        
        System.out.print("Enter nhacc name: ");
        String _name = sc.nextLine();
       
        Nhacc ncc = new Nhacc();
        ncc.setName(_name);
        
        libBean.addObject(ncc);
        
    } else if(choice == 8) {
        
        System.out.print("Enter nhacc id: ");
        String _idncc = sc.nextLine();
        
        System.out.print("Enter nhanvien id: ");
        String _idnv = sc.nextLine();
       
        libBean.addPhieu(Long.parseLong(_idncc), Long.parseLong(_idnv));
        
    } else if(choice == 9) {
        
        System.out.print("Enter hanghoa price: ");
        String _price = sc.nextLine();
        
        System.out.print("Enter hanghoa name: ");
        String _name = sc.nextLine();
       
        Hanghoa hh = new Hanghoa();
        hh.setName(_name);
        hh.setPrice(Long.parseLong(_price));
        
        libBean.addObject(hh);
        
    }  else if(choice == 10) {
        
        System.out.print("Enter nhanvien id: ");
        Long _idnv = Long.parseLong(sc.nextLine());
        
        libBean.addHoadon(_idnv);
        
        
    }   else if(choice == 11) {
        
        System.out.print("Enter hoadon id: ");
        Long _idhd = Long.parseLong(sc.nextLine());
         
        boolean _continue = true;
        
        while(_continue) {
     
            System.out.print("Enter hanghoa id: ");
            Long _idhh = Long.parseLong(sc.nextLine());

            System.out.print("Enter count: ");
            Long _count = Long.parseLong(sc.nextLine());
            
            libBean.addHdhh(_idhh, _idhd, _count);
            
            System.out.print("Do you want to add more item? (True or False)");
            
            _continue = Boolean.parseBoolean(sc.nextLine());
        
        }
        
    }    else if(choice == 12) {
        
        System.out.print("Enter phieu id: ");
        Long _idp = Long.parseLong(sc.nextLine());
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         
        boolean _continue = true;
        
        while(_continue) {
     
            System.out.print("Enter hanghoa id: ");
            Long _idhh = Long.parseLong(sc.nextLine());

            System.out.print("Enter count: ");
            Long _count = Long.parseLong(sc.nextLine());
            
            
            try {
                
                System.out.print("Enter startdate: ");
                Date _startdate = df.parse(sc.nextLine());
                
                System.out.print("Enter enddate: ");
                Date _enddate = df.parse(sc.nextLine());
               
                
                libBean.addHhp(_idp, _idhh, _startdate, _enddate, _count);
                
            } catch (ParseException ex) {
                Logger.getLogger(MyEJB10Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            System.out.print("Do you want to add more item? (True or False)");
            
            _continue = Boolean.parseBoolean(sc.nextLine());
        
        }
        
    } else if (choice == 13) {
        
        System.out.print("Enter nhanvien id need edit: ");
        Long _idnv = Long.parseLong(sc.nextLine());
        
        System.out.print("Enter nhanvien name: ");
        String _name = sc.nextLine();
        
        System.out.print("Enter nhanvien phone: ");
        String _phone = sc.nextLine();
        
        System.out.print("Enter nhanvien address: ");
        String _address = sc.nextLine();
        
        libBean.editNhanvien(_idnv, _name, _phone, _address);
        
    } 
    }
    sc.close();
    } catch (NamingException ex)
    {
    ex.getMessage();
    }
    }
    
}
