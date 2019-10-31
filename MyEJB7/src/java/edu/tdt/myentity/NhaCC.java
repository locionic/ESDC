/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.myentity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "NhaCC", catalog = "MyEJB8", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhaCC.findAll", query = "SELECT n FROM NhaCC n")
    , @NamedQuery(name = "NhaCC.findById", query = "SELECT n FROM NhaCC n WHERE n.id = :id")
    , @NamedQuery(name = "NhaCC.findByTen", query = "SELECT n FROM NhaCC n WHERE n.ten = :ten")})
public class NhaCC implements Serializable {

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
    @OneToMany(mappedBy = "idNcc")
    private Collection<Phieu> phieuCollection;

    public NhaCC() {
    }

    public NhaCC(Long id) {
        this.id = id;
    }

    public NhaCC(Long id, String ten) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhaCC)) {
            return false;
        }
        NhaCC other = (NhaCC) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.myentity.NhaCC[ id=" + id + " ]";
    }
    
}
