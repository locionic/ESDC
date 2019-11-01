/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author truonghongloc
 */
@Entity
@Table(name = "hoadon", catalog = "MyEJB10", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoadon.findAll", query = "SELECT h FROM Hoadon h")
    , @NamedQuery(name = "Hoadon.findById", query = "SELECT h FROM Hoadon h WHERE h.id = :id")
    , @NamedQuery(name = "Hoadon.findByDate", query = "SELECT h FROM Hoadon h WHERE h.date = :date")
    , @NamedQuery(name = "Hoadon.findByMoney", query = "SELECT h FROM Hoadon h WHERE h.money = :money")})
public class Hoadon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "money", nullable = false)
    private long money;
    @JoinColumn(name = "id_nv", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Nhanvien idNv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoadon")
    private Collection<Hdhh> hdhhCollection;

    public Hoadon() {
    }

    public Hoadon(Long id) {
        this.id = id;
    }

    public Hoadon(Long id, Date date, long money) {
        this.id = id;
        this.date = date;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public Nhanvien getIdNv() {
        return idNv;
    }

    public void setIdNv(Nhanvien idNv) {
        this.idNv = idNv;
    }

    @XmlTransient
    public Collection<Hdhh> getHdhhCollection() {
        return hdhhCollection;
    }

    public void setHdhhCollection(Collection<Hdhh> hdhhCollection) {
        this.hdhhCollection = hdhhCollection;
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
        if (!(object instanceof Hoadon)) {
            return false;
        }
        Hoadon other = (Hoadon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.Hoadon[ id=" + id + " ]";
    }
    
}
