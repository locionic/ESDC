/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.myentity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author truonghongloc
 */
@Entity
@Table(name = "HD_HH", catalog = "MyEJB8V2", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HdHh.findAll", query = "SELECT h FROM HdHh h")
    , @NamedQuery(name = "HdHh.findByMaHH", query = "SELECT h FROM HdHh h WHERE h.hdHhPK.maHH = :maHH")
    , @NamedQuery(name = "HdHh.findByMaHD", query = "SELECT h FROM HdHh h WHERE h.hdHhPK.maHD = :maHD")
    , @NamedQuery(name = "HdHh.findBySoLuong", query = "SELECT h FROM HdHh h WHERE h.soLuong = :soLuong")})
public class HdHh implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HdHhPK hdHhPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLuong", nullable = false)
    private long soLuong;
    @JoinColumn(name = "MaHH", referencedColumnName = "MaHH", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HangHoa hangHoa;
    @JoinColumn(name = "MaHH", referencedColumnName = "MaHD", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HoaDon hoaDon;

    public HdHh() {
    }

    public HdHh(HdHhPK hdHhPK) {
        this.hdHhPK = hdHhPK;
    }

    public HdHh(HdHhPK hdHhPK, long soLuong) {
        this.hdHhPK = hdHhPK;
        this.soLuong = soLuong;
    }

    public HdHh(long maHH, long maHD) {
        this.hdHhPK = new HdHhPK(maHH, maHD);
    }

    public HdHhPK getHdHhPK() {
        return hdHhPK;
    }

    public void setHdHhPK(HdHhPK hdHhPK) {
        this.hdHhPK = hdHhPK;
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

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hdHhPK != null ? hdHhPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HdHh)) {
            return false;
        }
        HdHh other = (HdHh) object;
        if ((this.hdHhPK == null && other.hdHhPK != null) || (this.hdHhPK != null && !this.hdHhPK.equals(other.hdHhPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.myentity.HdHh[ hdHhPK=" + hdHhPK + " ]";
    }
    
}
