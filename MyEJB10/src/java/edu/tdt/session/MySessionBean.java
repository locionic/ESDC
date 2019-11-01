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
        
    }
    
    @Override
    public void addHhp(Long idp, Long idhh, Date start, Date end, Long count) {
        
        Hhp hhp = new Hhp(idp, idhh);
        hhp.setCount(count);
        hhp.setEnddate(end);
        hhp.setStartdate(start);
        entityManager.persist(hhp);
        
    }
    
    
    
}
