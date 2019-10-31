/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author truonghongloc
 */
@Remote
public interface SystemManagementRemote {
    void insertUser(String userName, String userPassword);
    void insertRole(String roleName);
    void insertUserRole(String userName, String roleName);
    ArrayList<String> searchRole(String rolename);
    int getUserPassword(String username);
    //////////***********************************////////////
    
    
    
    
}
