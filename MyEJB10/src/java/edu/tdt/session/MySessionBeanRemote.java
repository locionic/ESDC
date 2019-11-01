/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.session;

import edu.tdt.entity.Nhanvien;
import edu.tdt.entity.Vitri;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author truonghongloc
 */
@Remote
public interface MySessionBeanRemote {
    void addObject(Object ob);
    List<Nhanvien> getNhanvien();
    void addTaikhoan(String name, String password, Long idnv, Long idvt);
    void addPhieu(Long idncc, Long idnv);
    void addHoadon(Long idnv);
    void addHdhh(Long a, Long b, Long c);
    void addHhp(Long a, Long b, Date c, Date d, Long e);
    

}
