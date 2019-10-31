/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.myentity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author truonghongloc
 */
@Entity
@Table(name = "ViTri", catalog = "MyEJB8V2", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViTri.findAll", query = "SELECT v FROM ViTri v")
    , @NamedQuery(name = "ViTri.findById", query = "SELECT v FROM ViTri v WHERE v.id = :id")
    , @NamedQuery(name = "ViTri.findByTen", query = "SELECT v FROM ViTri v WHERE v.ten = :ten")})
public class ViTri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Ten", nullable = false, length = 2147483647)
    private String ten;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDViTri")
    private Collection<Phieu> phieuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDViTri")
    private Collection<TaiKhoan> taiKhoanCollection;

    public ViTri() {
    }

    public ViTri(Long id) {
        this.id = id;
    }

    public ViTri(Long id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @XmlTransient
    public Collection<Phieu> getPhieuCollection() {
        return phieuCollection;
    }

    public void setPhieuCollection(Collection<Phieu> phieuCollection) {
        this.phieuCollection = phieuCollection;
    }

    @XmlTransient
    public Collection<TaiKhoan> getTaiKhoanCollection() {
        return taiKhoanCollection;
    }

    public void setTaiKhoanCollection(Collection<TaiKhoan> taiKhoanCollection) {
        this.taiKhoanCollection = taiKhoanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViTri)) {
            return false;
        }
        ViTri other = (ViTri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.myentity.ViTri[ id=" + id + " ]";
    }
    
}
