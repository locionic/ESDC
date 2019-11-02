/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "nhanvien", catalog = "MyEJB10", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n")
    , @NamedQuery(name = "Nhanvien.findById", query = "SELECT n FROM Nhanvien n WHERE n.id = :id")
    , @NamedQuery(name = "Nhanvien.findByName", query = "SELECT n FROM Nhanvien n WHERE n.name = :name")
    , @NamedQuery(name = "Nhanvien.findByPhone", query = "SELECT n FROM Nhanvien n WHERE n.phone = :phone")
    , @NamedQuery(name = "Nhanvien.findByAddress", query = "SELECT n FROM Nhanvien n WHERE n.address = :address")})
public class Nhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name", nullable = false, length = 2147483647)
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "phone", nullable = false, length = 2147483647)
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "address", nullable = false, length = 2147483647)
    private String address;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "nhanvien")
    private Taikhoan taikhoan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNv")
    private Collection<Hoadon> hoadonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNv")
    private Collection<Phieu> phieuCollection;

    public Nhanvien() {
    }

    public Nhanvien(Long id) {
        this.id = id;
    }

    public Nhanvien(Long id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Taikhoan getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(Taikhoan taikhoan) {
        this.taikhoan = taikhoan;
    }

    @XmlTransient
    public Collection<Hoadon> getHoadonCollection() {
        return hoadonCollection;
    }

    public void setHoadonCollection(Collection<Hoadon> hoadonCollection) {
        this.hoadonCollection = hoadonCollection;
    }

    @XmlTransient
    public Collection<Phieu> getPhieuCollection() {
        return phieuCollection;
    }

    public void setPhieuCollection(Collection<Phieu> phieuCollection) {
        this.phieuCollection = phieuCollection;
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
        if (!(object instanceof Nhanvien)) {
            return false;
        }
        Nhanvien other = (Nhanvien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.Nhanvien[ id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + " ]";
    }
    
}
