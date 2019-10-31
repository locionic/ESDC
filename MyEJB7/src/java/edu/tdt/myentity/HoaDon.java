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
@Table(name = "HoaDon", catalog = "MyEJB8V2", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDon.findAll", query = "SELECT h FROM HoaDon h")
    , @NamedQuery(name = "HoaDon.findByMaHD", query = "SELECT h FROM HoaDon h WHERE h.maHD = :maHD")
    , @NamedQuery(name = "HoaDon.findByNgayLap", query = "SELECT h FROM HoaDon h WHERE h.ngayLap = :ngayLap")
    , @NamedQuery(name = "HoaDon.findByThanhTien", query = "SELECT h FROM HoaDon h WHERE h.thanhTien = :thanhTien")})
public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaHD", nullable = false)
    private Long maHD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayLap", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngayLap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ThanhTien", nullable = false)
    private long thanhTien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaDon")
    private Collection<HdHh> hdHhCollection;
    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV", nullable = false)
    @ManyToOne(optional = false)
    private NhanVien maNV;

    public HoaDon() {
    }

    public HoaDon(Long maHD) {
        this.maHD = maHD;
    }

    public HoaDon(Long maHD, Date ngayLap, long thanhTien) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.thanhTien = thanhTien;
    }

    public Long getMaHD() {
        return maHD;
    }

    public void setMaHD(Long maHD) {
        this.maHD = maHD;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    @XmlTransient
    public Collection<HdHh> getHdHhCollection() {
        return hdHhCollection;
    }

    public void setHdHhCollection(Collection<HdHh> hdHhCollection) {
        this.hdHhCollection = hdHhCollection;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHD != null ? maHD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.maHD == null && other.maHD != null) || (this.maHD != null && !this.maHD.equals(other.maHD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.myentity.HoaDon[ maHD=" + maHD + " ]";
    }
    
}
