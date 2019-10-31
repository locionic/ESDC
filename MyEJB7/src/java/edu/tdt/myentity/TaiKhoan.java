/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.myentity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author truonghongloc
 */
@Entity
@Table(name = "TaiKhoan", catalog = "MyEJB8V2", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaiKhoan.findAll", query = "SELECT t FROM TaiKhoan t")
    , @NamedQuery(name = "TaiKhoan.findByTenTK", query = "SELECT t FROM TaiKhoan t WHERE t.tenTK = :tenTK")
    , @NamedQuery(name = "TaiKhoan.findByMatKhau", query = "SELECT t FROM TaiKhoan t WHERE t.matKhau = :matKhau")
    , @NamedQuery(name = "TaiKhoan.findByMaNV", query = "SELECT t FROM TaiKhoan t WHERE t.maNV = :maNV")})
public class TaiKhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "TenTK", nullable = false, length = 2147483647)
    private String tenTK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "MatKhau", nullable = false, length = 2147483647)
    private String matKhau;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNV", nullable = false)
    private Long maNV;
    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private NhanVien nhanVien;
    @JoinColumn(name = "ID_ViTri", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ViTri iDViTri;

    public TaiKhoan() {
    }

    public TaiKhoan(Long maNV) {
        this.maNV = maNV;
    }

    public TaiKhoan(Long maNV, String tenTK, String matKhau) {
        this.maNV = maNV;
        this.tenTK = tenTK;
        this.matKhau = matKhau;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Long getMaNV() {
        return maNV;
    }

    public void setMaNV(Long maNV) {
        this.maNV = maNV;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
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
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan other = (TaiKhoan) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.myentity.TaiKhoan[ maNV=" + maNV + " ]";
    }
    
}
