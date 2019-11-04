/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.session;

import edu.tdt.entity.Hanghoa;
import edu.tdt.entity.Hdhh;
import edu.tdt.entity.Hhp;
import edu.tdt.entity.Hoadon;
import edu.tdt.entity.Nhacc;
import edu.tdt.entity.Nhanvien;
import edu.tdt.entity.Phieu;
import edu.tdt.entity.Taikhoan;
import edu.tdt.entity.Vitri;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author truonghongloc
 */
@Stateful
public class MySessionBean implements MySessionBeanRemote {

    @PersistenceContext(unitName = "MyEJB10PU")
    private EntityManager entityManager;
    
    public MySessionBean() {
        
    }

    @Override
    public void addObject(Object ob) {
        entityManager.persist(ob);
        if (Hanghoa.class.isInstance(ob)) {
            System.out.println("Hang hoa");
        }
        System.out.println("Add Successful");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void addTaikhoan(String name, String password, Long idnv, Long idvt) {
        Vitri test = (Vitri) entityManager.createNamedQuery("Vitri.findById").setParameter("id", idvt).getSingleResult();
        System.out.println(test);
        Taikhoan tk = new Taikhoan();
        tk.setName(name);
        tk.setIdNv(idnv);
        tk.setPassword(password);
        tk.setIdVt(test);
        entityManager.persist(tk);
        System.out.println("Success add taikhoan");
    }
    
   

    @Override
    public List<Nhanvien> getNhanvien() {
        return entityManager.createNamedQuery("Nhanvien.findAll").getResultList();
//        System.out.println("Get dc ne");
//        for (Nhanvien nv : mylist) {
//            System.out.println(nv.toString());
//        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPhieu(Long idncc, Long idnv) {
        Nhanvien nv = (Nhanvien) entityManager.createNamedQuery("Nhanvien.findById").setParameter("id", idnv).getSingleResult();
        Nhacc ncc = (Nhacc) entityManager.createNamedQuery("Nhacc.findById").setParameter("id", idncc).getSingleResult();
        Phieu p = new Phieu();
        p.setDate(new Date());
        p.setIdNcc(ncc);
        p.setIdNv(nv);
        entityManager.persist(p);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void addHoadon(Long idnv) {
        
        Hoadon hd = new Hoadon();
        hd.setDate(new Date());
        hd.setMoney(new Long(0));
        Nhanvien nv = (Nhanvien) entityManager.createNamedQuery("Nhanvien.findById").setParameter("id", idnv).getSingleResult();
        hd.setIdNv(nv);
        entityManager.persist(hd);
        
    }
    
    @Override
    public void addHdhh(Long idhh, Long idhd, Long count) {
        
        Hdhh hdhh = new Hdhh(idhh, idhd);
        hdhh.setCount(count);
        entityManager.persist(hdhh);
        
        sumAgain(count, idhh, idhd);
 
    }
    
    @Override
    public void addHhp(Long idp, Long idhh, Date start, Date end, Long count) {
        
        Hhp hhp = new Hhp(idp, idhh);
        hhp.setCount(count);
        hhp.setEnddate(end);
        hhp.setStartdate(start);
        entityManager.persist(hhp);
        
    }
    
    @Override
    public void editNhanvien(Long idnv, String name, String phone, String address) {
        Nhanvien a = (Nhanvien) entityManager.createNamedQuery("Nhanvien.findById").setParameter("id", idnv).getSingleResult();
        a.setAddress(address);
        a.setName(name);
        a.setPhone(phone);
        entityManager.merge(a);
    }

    @Override
    public void editTaikhoan(Long idnv, String name, String password) {
        
        Taikhoan a = (Taikhoan) entityManager.createNamedQuery("Taikhoan.findByIdNv").setParameter("idNv", idnv).getSingleResult();
        a.setName(name);
        a.setPassword(password);
        entityManager.merge(a);
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editVitri(Long idvt, String name) {
        
        Vitri a = (Vitri) entityManager.createNamedQuery("Vitri.findById").setParameter("id", idvt).getSingleResult();
        a.setName(name);
        entityManager.merge(a);
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editPhieu(Long idp, Long idncc, Long idnv) {
        
        Phieu a = (Phieu) entityManager.createNamedQuery("Phieu.findById").setParameter("id", idp).getSingleResult();
        Nhacc ncc = (Nhacc) entityManager.createNamedQuery("Nhacc.findById").setParameter("id", idncc).getSingleResult();
        Nhanvien nv = (Nhanvien) entityManager.createNamedQuery("Nhanvien.findById").setParameter("id", idnv).getSingleResult();
        
        a.setIdNcc(ncc);
        a.setIdNv(nv);
        
        entityManager.merge(a);
        
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editNhacc(Long idncc, String name) {
        
        Nhacc a = (Nhacc) entityManager.createNamedQuery("Nhacc.findById").setParameter("id", idncc).getSingleResult();
        a.setName(name);
        
        entityManager.merge(a);
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editHhp(Long idp, Long idhh, Date startdate, Date enddate, Long count) {
        
        List<Hhp> mylist = entityManager.createNamedQuery("Hhp.findAll").getResultList();
        for (Hhp hhp : mylist) {
            if (hhp.getHhpPK().getIdHh() == idhh && hhp.getHhpPK().getIdP() == idp) {
                hhp.setCount(count);
                hhp.setEnddate(enddate);
                hhp.setStartdate(startdate);
                entityManager.merge(hhp);
                break;
            }
        }
        System.out.println("Edit hhp success");
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editHanghoa(Long id, Long price, String name) {
        
        Hanghoa a = (Hanghoa) entityManager.createNamedQuery("Hanghoa.findById").setParameter("id", id).getSingleResult();
        a.setPrice(price);
        a.setName(name);
        entityManager.merge(a);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editHdhh(Long idhh, Long idhd, Long count) {
        
        List<Hdhh> mylist = entityManager.createNamedQuery("Hdhh.findAll").getResultList();
        for (Hdhh hdhh : mylist) {
            if (hdhh.getHdhhPK().getIdHd() == idhd && hdhh.getHdhhPK().getIdHh() == idhh) {
                hdhh.setCount(count);
                entityManager.merge(hdhh);
                break;
            }
        }
        System.out.println("Edit hdhh success");
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editHoadon(Long id, Long money, Long idnv) {
        
        Hoadon a = (Hoadon) entityManager.createNamedQuery("Hoadon.findById").setParameter("id", id).getSingleResult();
        a.setMoney(money);
        a.setMoney(money);
        Nhanvien nv = (Nhanvien) entityManager.createNamedQuery("Nhanvien.findById").setParameter("id", idnv).getSingleResult();
        a.setIdNv(nv);
        
        entityManager.merge(a);
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void deleteNhacc(Long id) {
        Nhacc ncc = (Nhacc) entityManager.createNamedQuery("Nhacc.findById").setParameter("id", id).getSingleResult();
        entityManager.remove(ncc);
    }
    

    
    @Override
    public String showAllNhanvien() {
        List<Nhanvien> ml = entityManager.createNamedQuery("Nhanvien.findAll").getResultList();
        String a = "";
        for (Nhanvien nv : ml) {
            a = a + nv.toString() + "\n";
        }
        return a;
    }

    @Override
    public String showAllTaikhoan() {
        
        List<Taikhoan> ml = entityManager.createNamedQuery("Taikhoan.findAll").getResultList();
        String a = "";
        for (Taikhoan nv : ml) {
            a = a + nv.toString() + "\n";
        }
        return a;
        
    }

    @Override
    public String showAllVitri() {
        List<Vitri> ml = entityManager.createNamedQuery("Vitri.findAll").getResultList();
        String a = "";
        for (Vitri nv : ml) {
            a = a + nv.toString() + "\n";
        }
        return a;
    }

    @Override
    public String showAllPhieu() {
        List<Phieu> ml = entityManager.createNamedQuery("Phieu.findAll").getResultList();
        String a = "";
        for (Phieu nv : ml) {
            a = a + nv.toString() + "\n";
        }
        return a;
    }

    @Override
    public String showAllHhp() {
        List<Hhp> ml = entityManager.createNamedQuery("Hhp.findAll").getResultList();
        String a = "";
        for (Hhp nv : ml) {
            a = a + nv.toString() + "\n";
        }
        return a;
    }

    @Override
    public String showAllHanghoa() {
        List<Hanghoa> ml = entityManager.createNamedQuery("Hanghoa.findAll").getResultList();
        String a = "";
        for (Hanghoa nv : ml) {
            a = a + nv.toString() + "\n";
        }
        return a;
    }

    @Override
    public String showAllHdhh() {
        List<Hdhh> ml = entityManager.createNamedQuery("Hdhh.findAll").getResultList();
        String a = "";
        for (Hdhh nv : ml) {
            a = a + nv.toString() + "\n";
        }
        return a; 
    }

    @Override
    public String showAllHoadon() {
        List<Hoadon> ml = entityManager.createNamedQuery("Hoadon.findAll").getResultList();
        String a = "";
        for (Hoadon nv : ml) {
            a = a + nv.toString() + "\n";
        }
        return a;    }

    @Override
    public String showAllNhacc() {
        List<Nhacc> ml = entityManager.createNamedQuery("Nhacc.findAll").getResultList();
        String a = "";
        for (Nhacc nv : ml) {
            a = a + nv.toString() + "\n";
        }
        return a;
    }
    
    @Override
    public List<Taikhoan> getTaikhoan() {
        
        return entityManager.createNamedQuery("Taikhoan.findAll").getResultList();
        
        
    }

    @Override
    public String getVitriFromTaikhoan(String username, String password) {
        
        List<Taikhoan> ml = entityManager.createNamedQuery("Taikhoan.findAll").getResultList();
        for (Taikhoan tk : ml) {
            if (tk.getName().equals(username) && tk.getPassword().equals(password)) {
                return tk.getIdVt().getName();
            }
        }
        
        return null;
    }
    
    @Override
    public void banHang(Long idhh, Long idnv, Long sl) {
        Hoadon hd = new Hoadon();
        hd.setDate(new Date());
        hd.setMoney(0);
        hd.setIdNv( (Nhanvien) entityManager.createNamedQuery("Nhanvien.findById").setParameter("id", idnv).getSingleResult());
        entityManager.persist(hd);
        System.out.println(hd.getId());
        Hdhh hdhh = new Hdhh(idhh, hd.getId());
        hdhh.setCount(sl);
        hd.getHdhhCollection().add(hdhh);
        entityManager.merge(hd);
    }
    
    @Override
    public void sumAgain(Long count, Long idhh, Long idhd) {
        Hoadon hd = (Hoadon) entityManager.createNamedQuery("Hoadon.findById").setParameter("id", idhd).getSingleResult();
        Hanghoa hh = (Hanghoa) entityManager.createNamedQuery("Hanghoa.findById").setParameter("id", idhh).getSingleResult();
        hd.setMoney(hd.getMoney() + count * hh.getPrice());
        entityManager.merge(hd);
    }
    
    @Override
    public Long checkSL(Long idhh) {
        
        Hanghoa hh = (Hanghoa) entityManager.createNamedQuery("Hanghoa.findById").setParameter("id", idhh).getSingleResult();
        long a = 0;
        for (Hhp hhp : hh.getHhpCollection()) {
           a = a + hhp.getCount();
        }
        return a;
        
    }
    
}
