/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.myentity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author truonghongloc
 */
@Entity
@Table(name = "HH_P", catalog = "MyEJB8V2", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HhP.findAll", query = "SELECT h FROM HhP h")
    , @NamedQuery(name = "HhP.findByMaP", query = "SELECT h FROM HhP h WHERE h.hhPPK.maP = :maP")
    , @NamedQuery(name = "HhP.findByMaHH", query = "SELECT h FROM HhP h WHERE h.hhPPK.maHH = :maHH")
    , @NamedQuery(name = "HhP.findByNgaySX", query = "SELECT h FROM HhP h WHERE h.ngaySX = :ngaySX")
    , @NamedQuery(name = "HhP.findByNgayHH", query = "SELECT h FROM HhP h WHERE h.ngayHH = :ngayHH")
    , @NamedQuery(name = "HhP.findBySoLuong", query = "SELECT h FROM HhP h WHERE h.soLuong = :soLuong")})
public class HhP implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HhPPK hhPPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgaySX", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngaySX;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayHH", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngayHH;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLuong", nullable = false)
    private long soLuong;
    @JoinColumn(name = "MaHH", referencedColumnName = "MaHH", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HangHoa hangHoa;
    @JoinColumn(name = "MaP", referencedColumnName = "MaP", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Phieu phieu;

    public HhP() {
    }

    public HhP(HhPPK hhPPK) {
        this.hhPPK = hhPPK;
    }

    public HhP(HhPPK hhPPK, Date ngaySX, Date ngayHH, long soLuong) {
        this.hhPPK = hhPPK;
        this.ngaySX = ngaySX;
        this.ngayHH = ngayHH;
        this.soLuong = soLuong;
    }

    public HhP(long maP, long maHH) {
        this.hhPPK = new HhPPK(maP, maHH);
    }

    public HhPPK getHhPPK() {
        return hhPPK;
    }

    public void setHhPPK(HhPPK hhPPK) {
        this.hhPPK = hhPPK;
    }

    public Date getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }

    public Date getNgayHH() {
        return ngayHH;
    }

    public void setNgayHH(Date ngayHH) {
        this.ngayHH = ngayHH;
    }

    public long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(long soLuong) {
        this.soLuong = soLuong;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

    public Phieu getPhieu() {
        return phieu;
    }

    public void setPhieu(Phieu phieu) {
        this.phieu = phieu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hhPPK != null ? hhPPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhP)) {
            return false;
        }
        HhP other = (HhP) object;
        if ((this.hhPPK == null && other.hhPPK != null) || (this.hhPPK != null && !this.hhPPK.equals(other.hhPPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.myentity.HhP[ hhPPK=" + hhPPK + " ]";
    }
    
}
