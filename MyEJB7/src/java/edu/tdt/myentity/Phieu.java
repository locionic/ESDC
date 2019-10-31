/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.myentity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Phieu", catalog = "MyEJB8V2", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phieu.findAll", query = "SELECT p FROM Phieu p")
    , @NamedQuery(name = "Phieu.findByMaP", query = "SELECT p FROM Phieu p WHERE p.maP = :maP")
    , @NamedQuery(name = "Phieu.findByNgayLap", query = "SELECT p FROM Phieu p WHERE p.ngayLap = :ngayLap")})
public class Phieu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaP", nullable = false)
    private Long maP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayLap", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngayLap;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phieu")
    private Collection<HhP> hhPCollection;
    @JoinColumn(name = "ID_NCC", referencedColumnName = "ID")
    @ManyToOne
    private NhaCC idNcc;
    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV", nullable = false)
    @ManyToOne(optional = false)
    private NhanVien maNV;
    @JoinColumn(name = "ID_ViTri", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ViTri iDViTri;

    public Phieu() {
    }

    public Phieu(Long maP) {
        this.maP = maP;
    }

    public Phieu(Long maP, Date ngayLap) {
        this.maP = maP;
        this.ngayLap = ngayLap;
    }

    public Long getMaP() {
        return maP;
    }

    public void setMaP(Long maP) {
        this.maP = maP;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    @XmlTransient
    public Collection<HhP> getHhPCollection() {
        return hhPCollection;
    }

    public void setHhPCollection(Collection<HhP> hhPCollection) {
        this.hhPCollection = hhPCollection;
    }

    public NhaCC getIdNcc() {
        return idNcc;
    }

    public void setIdNcc(NhaCC idNcc) {
        this.idNcc = idNcc;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    public ViTri getIDViTri() {
        return iDViTri;
    }

    public void setIDViTri(ViTri iDViTri) {
        this.iDViTri = iDViTri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maP != null ? maP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phieu)) {
            return false;
        }
        Phieu other = (Phieu) object;
        if ((this.maP == null && other.maP != null) || (this.maP != null && !this.maP.equals(other.maP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.myentity.Phieu[ maP=" + maP + " ]";
    }
    
}
