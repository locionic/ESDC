/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author truonghongloc
 */
@Entity
@Table(name = "taikhoan", catalog = "MyEJB10", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taikhoan.findAll", query = "SELECT t FROM Taikhoan t")
    , @NamedQuery(name = "Taikhoan.findByName", query = "SELECT t FROM Taikhoan t WHERE t.name = :name")
    , @NamedQuery(name = "Taikhoan.findByPassword", query = "SELECT t FROM Taikhoan t WHERE t.password = :password")
    , @NamedQuery(name = "Taikhoan.findByIdNv", query = "SELECT t FROM Taikhoan t WHERE t.idNv = :idNv")})
public class Taikhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name", nullable = false, length = 2147483647)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "password", nullable = false, length = 2147483647)
    private String password;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nv", nullable = false)
    private Long idNv;
    @JoinColumn(name = "id_nv", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Nhanvien nhanvien;
    @JoinColumn(name = "id_vt", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Vitri idVt;

    public Taikhoan() {
    }

    public Taikhoan(Long idNv) {
        this.idNv = idNv;
    }

    public Taikhoan(Long idNv, String name, String password) {
        this.idNv = idNv;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdNv() {
        return idNv;
    }

    public void setIdNv(Long idNv) {
        this.idNv = idNv;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public Vitri getIdVt() {
        return idVt;
    }

    public void setIdVt(Vitri idVt) {
        this.idVt = idVt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNv != null ? idNv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taikhoan)) {
            return false;
        }
        Taikhoan other = (Taikhoan) object;
        if ((this.idNv == null && other.idNv != null) || (this.idNv != null && !this.idNv.equals(other.idNv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.Taikhoan[ idNv=" + idNv + " ]";
    }
    
}
