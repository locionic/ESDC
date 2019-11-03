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
public class MyEJB10TestV2 {

    private Properties props;

    private InitialContext ctx;

    private MySessionBeanRemote libBean;

    public MyEJB10TestV2()
    {
        readJNDI();
        try {
            libBean = (MySessionBeanRemote) ctx.lookup(getJNDI());
        } catch (NamingException ex) {
            Logger.getLogger(MyEJB10TestV2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public void addVitri(String name) {
        
        Vitri b = new Vitri();
        
        b.setName(name);

        libBean.addObject(b);
    }
    
    public void addTaikhoan(String name, String password, Long idnv, Long idvt) {
        libBean.addTaikhoan(name, password, idnv, idvt);
    }
    
    public void addNhacc(String name) {
        Nhacc ncc = new Nhacc();
        ncc.setName(name);
        libBean.addObject(ncc);
    }
    
    public void addPhieu(Long idncc, Long idnv) {
        
        libBean.addPhieu(idncc, idnv);
        
    }
    
    public void addHanghoa(Long price, String name) {
        
        Hanghoa hh = new Hanghoa();
        hh.setName(name);
        hh.setPrice(price);
        
        libBean.addObject(hh);
        
    }
    
    public void addHoadon(Long idnv) {
        
        libBean.addHoadon(idnv);
        
        
    }
    
    public void addHdhh(Long idhd, Long idhh, Long count) {
        
        libBean.addHdhh(idhh, idhh, count);
        
    } 
    
    public void addHhp(Long idp, Long idhh, Long count, Date start, Date end) {
        
        libBean.addHhp(idp, idhh, start, end, count);
        
    }
    
    public void editNhanvien(Long idnv, String name, String phone, String address) {
        
       libBean.editNhanvien(idnv, name, phone, address);
       
    }
    
    public void editHdhh(Long idhd, Long idhh, Long count) {
        
        
        libBean.editHdhh(idhh, idhd, count);
        
    }
    
    public void editHhp(Long idp, Long idhh, Date start, Date end, Long count) {
        
        libBean.editHhp(idp, idhh, start, end, count);
        
    }
    
    public void editVitri(Long idvt, String name) {
        
        libBean.editVitri(idvt, name);
        
    }
    
    public void editTaikhoan(Long idnv, String name, String password) {
       
        libBean.editTaikhoan(idnv, name, password);
       
    }
    
    public void editPhieu(Long idp, Long idncc, Long idnv) {
        
        libBean.editPhieu(idp, idncc, idnv);
       
    }
    
    public void editNhacc(Long idncc, String name) {
        
        libBean.editNhacc(idncc, name);
         
    }

    public void editHanghoa(Long idhh, Long price, String name) {
        
        libBean.editHanghoa(idhh, price, name);
        
    }

    public void editHoadon(Long id, Long money, Long idnv) {
        
        libBean.editHoadon(id, money, idnv);
        
    }

    public void deleteNhacc(Long idncc) {
        
        libBean.deleteNhacc(idncc);
        
    }

    public String showNhanvien() {
        
        return (libBean.showAllNhanvien());

        
    }

    public String showTaikhoan() {
        
        return (libBean.showAllTaikhoan());

        
    }

    public String showVitri() {
        
        return (libBean.showAllVitri());

        
    }

    public String showPhieu() {
        
        return (libBean.showAllPhieu());

        
    }

    public String showNhacc() {
        
        return (libBean.showAllNhacc());

        
    }

    public String showHhp() {
        
        return (libBean.showAllHhp());

        
    }
    
    public String showHanghoa() {
        
        return (libBean.showAllHanghoa());

        
    }

    public String showHdhh() {
        
        return (libBean.showAllHdhh());

        
    }

    public String showHoadon() {
        
        return (libBean.showAllHoadon());

        
    }
    
}
