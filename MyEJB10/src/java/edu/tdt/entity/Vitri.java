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
@Table(name = "vitri", catalog = "MyEJB10", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vitri.findAll", query = "SELECT v FROM Vitri v")
    , @NamedQuery(name = "Vitri.findById", query = "SELECT v FROM Vitri v WHERE v.id = :id")
    , @NamedQuery(name = "Vitri.findByName", query = "SELECT v FROM Vitri v WHERE v.name = :name")})
public class Vitri implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVt")
    private Collection<Taikhoan> taikhoanCollection;

    public Vitri() {
    }

    public Vitri(Long id) {
        this.id = id;
    }

    public Vitri(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public Collection<Taikhoan> getTaikhoanCollection() {
        return taikhoanCollection;
    }

    public void setTaikhoanCollection(Collection<Taikhoan> taikhoanCollection) {
        this.taikhoanCollection = taikhoanCollection;
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
        if (!(object instanceof Vitri)) {
            return false;
        }
        Vitri other = (Vitri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.Vitri[ id=" + id + " ]";
    }
    
}
