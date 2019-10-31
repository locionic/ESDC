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
@Table(name = "HangHoa", catalog = "MyEJB8V2", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HangHoa.findAll", query = "SELECT h FROM HangHoa h")
    , @NamedQuery(name = "HangHoa.findByMaHH", query = "SELECT h FROM HangHoa h WHERE h.maHH = :maHH")
    , @NamedQuery(name = "HangHoa.findByDonGia", query = "SELECT h FROM HangHoa h WHERE h.donGia = :donGia")
    , @NamedQuery(name = "HangHoa.findByTen", query = "SELECT h FROM HangHoa h WHERE h.ten = :ten")
    , @NamedQuery(name = "HangHoa.findByXuatSu", query = "SELECT h FROM HangHoa h WHERE h.xuatSu = :xuatSu")})
public class HangHoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaHH", nullable = false)
    private Long maHH;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DonGia", nullable = false)
    private long donGia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Ten", nullable = false, length = 2147483647)
    private String ten;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "XuatSu", nullable = false, length = 2147483647)
    private String xuatSu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hangHoa")
    private Collection<HhP> hhPCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hangHoa")
    private Collection<HdHh> hdHhCollection;

    public HangHoa() {
    }

    public HangHoa(Long maHH) {
        this.maHH = maHH;
    }

    public HangHoa(Long maHH, long donGia, String ten, String xuatSu) {
        this.maHH = maHH;
        this.donGia = donGia;
        this.ten = ten;
        this.xuatSu = xuatSu;
    }

    public Long getMaHH() {
        return maHH;
    }

    public void setMaHH(Long maHH) {
        this.maHH = maHH;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getXuatSu() {
        return xuatSu;
    }

    public void setXuatSu(String xuatSu) {
        this.xuatSu = xuatSu;
    }

    @XmlTransient
    public Collection<HhP> getHhPCollection() {
        return hhPCollection;
    }

    public void setHhPCollection(Collection<HhP> hhPCollection) {
        this.hhPCollection = hhPCollection;
    }

    @XmlTransient
    public Collection<HdHh> getHdHhCollection() {
        return hdHhCollection;
    }

    public void setHdHhCollection(Collection<HdHh> hdHhCollection) {
        this.hdHhCollection = hdHhCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHH != null ? maHH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HangHoa)) {
            return false;
        }
        HangHoa other = (HangHoa) object;
        if ((this.maHH == null && other.maHH != null) || (this.maHH != null && !this.maHH.equals(other.maHH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.myentity.HangHoa[ maHH=" + maHH + " ]";
    }
    
}
