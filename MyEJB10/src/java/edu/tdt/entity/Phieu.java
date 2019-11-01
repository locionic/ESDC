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
@Table(name = "phieu", catalog = "MyEJB10", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phieu.findAll", query = "SELECT p FROM Phieu p")
    , @NamedQuery(name = "Phieu.findById", query = "SELECT p FROM Phieu p WHERE p.id = :id")
    , @NamedQuery(name = "Phieu.findByDate", query = "SELECT p FROM Phieu p WHERE p.date = :date")})
public class Phieu implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phieu")
    private Collection<Hhp> hhpCollection;
    @JoinColumn(name = "id_ncc", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Nhacc idNcc;
    @JoinColumn(name = "id_nv", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Nhanvien idNv;

    public Phieu() {
    }

    public Phieu(Long id) {
        this.id = id;
    }

    public Phieu(Long id, Date date) {
        this.id = id;
        this.date = date;
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

    @XmlTransient
    public Collection<Hhp> getHhpCollection() {
        return hhpCollection;
    }

    public void setHhpCollection(Collection<Hhp> hhpCollection) {
        this.hhpCollection = hhpCollection;
    }

    public Nhacc getIdNcc() {
        return idNcc;
    }

    public void setIdNcc(Nhacc idNcc) {
        this.idNcc = idNcc;
    }

    public Nhanvien getIdNv() {
        return idNv;
    }

    public void setIdNv(Nhanvien idNv) {
        this.idNv = idNv;
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
        if (!(object instanceof Phieu)) {
            return false;
        }
        Phieu other = (Phieu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.Phieu[ id=" + id + " ]";
    }
    
}
