/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.myentity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "NhanVien", catalog = "MyEJB8", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n")
    , @NamedQuery(name = "NhanVien.findByMaNV", query = "SELECT n FROM NhanVien n WHERE n.maNV = :maNV")
    , @NamedQuery(name = "NhanVien.findByHoVaTen", query = "SELECT n FROM NhanVien n WHERE n.hoVaTen = :hoVaTen")
    , @NamedQuery(name = "NhanVien.findBySoPhone", query = "SELECT n FROM NhanVien n WHERE n.soPhone = :soPhone")
    , @NamedQuery(name = "NhanVien.findByDiaChi", query = "SELECT n FROM NhanVien n WHERE n.diaChi = :diaChi")})
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNV", nullable = false)
    private Long maNV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "HoVaTen", nullable = false, length = 2147483647)
    private String hoVaTen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "SoPhone", nullable = false, length = 2147483647)
    private String soPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "DiaChi", nullable = false, length = 2147483647)
    private String diaChi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maNV")
    private Collection<Phieu> phieuCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "nhanVien")
    private TaiKhoan taiKhoan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maNV")
    private Collection<HoaDon> hoaDonCollection;

    public NhanVien() {
    }

    public NhanVien(Long maNV) {
        this.maNV = maNV;
    }

    public NhanVien(Long maNV, String hoVaTen, String soPhone, String diaChi) {
        this.maNV = maNV;
        this.hoVaTen = hoVaTen;
        this.soPhone = soPhone;
        this.diaChi = diaChi;
    }

    public Long getMaNV() {
        return maNV;
    }

    public void setMaNV(Long maNV) {
        this.maNV = maNV;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getSoPhone() {
        return soPhone;
    }

    public void setSoPhone(String soPhone) {
        this.soPhone = soPhone;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @XmlTransient
    public Collection<Phieu> getPhieuCollection() {
        return phieuCollection;
    }

    public void setPhieuCollection(Collection<Phieu> phieuCollection) {
        this.phieuCollection = phieuCollection;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    @XmlTransient
    public Collection<HoaDon> getHoaDonCollection() {
        return hoaDonCollection;
    }

    public void setHoaDonCollection(Collection<HoaDon> hoaDonCollection) {
        this.hoaDonCollection = hoaDonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.myentity.NhanVien[ maNV=" + maNV + " ]";
    }
    
}
