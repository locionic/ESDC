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
@Table(name = "hanghoa", catalog = "MyEJB10", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hanghoa.findAll", query = "SELECT h FROM Hanghoa h")
    , @NamedQuery(name = "Hanghoa.findById", query = "SELECT h FROM Hanghoa h WHERE h.id = :id")
    , @NamedQuery(name = "Hanghoa.findByPrice", query = "SELECT h FROM Hanghoa h WHERE h.price = :price")
    , @NamedQuery(name = "Hanghoa.findByName", query = "SELECT h FROM Hanghoa h WHERE h.name = :name")})
public class Hanghoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price", nullable = false)
    private long price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name", nullable = false, length = 2147483647)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hanghoa")
    private Collection<Hhp> hhpCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hanghoa")
    private Collection<Hdhh> hdhhCollection;

    public Hanghoa() {
    }

    public Hanghoa(Long id) {
        this.id = id;
    }

    public Hanghoa(Long id, long price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Hhp> getHhpCollection() {
        return hhpCollection;
    }

    public void setHhpCollection(Collection<Hhp> hhpCollection) {
        this.hhpCollection = hhpCollection;
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
        if (!(object instanceof Hanghoa)) {
            return false;
        }
        Hanghoa other = (Hanghoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.Hanghoa[ id=" + id + ", name=" + name + ", price=" + price + " ]";
    }
    
}
