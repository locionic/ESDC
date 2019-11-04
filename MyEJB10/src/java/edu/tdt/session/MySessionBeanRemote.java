/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.session;

import edu.tdt.entity.Hanghoa;
import edu.tdt.entity.Nhacc;
import edu.tdt.entity.Nhanvien;
import edu.tdt.entity.Phieu;
import edu.tdt.entity.Taikhoan;
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
    
    

    /**************/

    public void editNhanvien(Long idnv, String name, String phone, String address);
    
    public void editTaikhoan(Long idnv, String name, String password);
    
    public void editVitri(Long idvt, String name);
    
    public void editPhieu(Long idp, Long idncc, Long idnv);
    
    public void editNhacc(Long idncc, String name);
    
    public void editHhp(Long idp, Long idhh, Date startdate, Date enddate, Long count);
    
    public void editHanghoa(Long id, Long price, String name);
    
    public void editHdhh(Long idhh, Long idhd, Long count);
    
    public void editHoadon(Long id, Long money, Long idnv);
    
    public void deleteNhacc(Long id);
    
//    public List<Nhanvien> getAllNhanVien();
//    public List<Hanghoa> getAllHangHoa();
//    public List<Vitri> getAllViTri();
//    public List<Phieu> getAllPhieu();
//    public List<Nhacc> getAllNhaCC();
    
    public String showAllNhanvien();
    
    public String showAllTaikhoan();
    
    public String showAllVitri();
    
    public String showAllPhieu();
    
    public String showAllHhp();
    
    public String showAllHanghoa();
    
    public String showAllHdhh();
    
    public String showAllHoadon();
    
    public String showAllNhacc();
    
    public List<Taikhoan> getTaikhoan();
    
    public String getVitriFromTaikhoan(String username, String password);
    
    /*************************/
    public void banHang(Long idhh, Long idnv, Long sl);
    
    public void sumAgain(Long count, Long idhh, Long idhd);
    
    public Long checkSL(Long idhh);
    
    

}
