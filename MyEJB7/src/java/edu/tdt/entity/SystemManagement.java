/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

import java.util.ArrayList;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author truonghongloc
 */
@Stateful
public class SystemManagement implements SystemManagementRemote {

    @PersistenceContext(unitName = "MyEJB7PU")
    private EntityManager em;
    public SystemManagement()
    {
    }
    @Override
    public void insertUser(String userName, String userPassword)
    {
    User user = new User(userName, userPassword);
    em.persist(user);
    }
    @Override
    public void insertRole(String roleName)
    {
    Role role = new Role(roleName);
    em.persist(role);
    }
    @Override
    public void insertUserRole(String userName, String roleName)
    {
    User user = em.find(User.class, userName);
    Role role = em.find(Role.class, roleName);
    user.getRoleCollection().add(role);
    role.getUserCollection().add(user);
    }
    @Override
    public ArrayList<String> searchRole(String rolename)
    {
    Role role = em.find(Role.class, rolename);
    if(role != null)
    {
    ArrayList<String> arrOutput = new ArrayList<String>();
    for(User user : role.getUserCollection())
    {
    arrOutput.add(user.getName());
    }
    return arrOutput;
    }
    return null;
    }
    @Override
    public int getUserPassword(String username)
    {
    User user = em.find(User.class, username);
    if(user != null)
    return user.getPassword().hashCode();
    return -1;
    }
    //////////***********************************////////////
    
    
    
    
    
}
