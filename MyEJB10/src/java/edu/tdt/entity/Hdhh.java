/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

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
@Table(name = "hdhh", catalog = "MyEJB10", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hdhh.findAll", query = "SELECT h FROM Hdhh h")
    , @NamedQuery(name = "Hdhh.findByIdHh", query = "SELECT h FROM Hdhh h WHERE h.hdhhPK.idHh = :idHh")
    , @NamedQuery(name = "Hdhh.findByIdHd", query = "SELECT h FROM Hdhh h WHERE h.hdhhPK.idHd = :idHd")
    , @NamedQuery(name = "Hdhh.findByCount", query = "SELECT h FROM Hdhh h WHERE h.count = :count")})
public class Hdhh implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HdhhPK hdhhPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count", nullable = false)
    private long count;
    @JoinColumn(name = "id_hh", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hanghoa hanghoa;
    @JoinColumn(name = "id_hd", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hoadon hoadon;

    public Hdhh() {
    }

    public Hdhh(HdhhPK hdhhPK) {
        this.hdhhPK = hdhhPK;
    }

    public Hdhh(HdhhPK hdhhPK, long count) {
        this.hdhhPK = hdhhPK;
        this.count = count;
    }

    public Hdhh(long idHh, long idHd) {
        this.hdhhPK = new HdhhPK(idHh, idHd);
    }

    public HdhhPK getHdhhPK() {
        return hdhhPK;
    }

    public void setHdhhPK(HdhhPK hdhhPK) {
        this.hdhhPK = hdhhPK;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Hanghoa getHanghoa() {
        return hanghoa;
    }

    public void setHanghoa(Hanghoa hanghoa) {
        this.hanghoa = hanghoa;
    }

    public Hoadon getHoadon() {
        return hoadon;
    }

    public void setHoadon(Hoadon hoadon) {
        this.hoadon = hoadon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hdhhPK != null ? hdhhPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hdhh)) {
            return false;
        }
        Hdhh other = (Hdhh) object;
        if ((this.hdhhPK == null && other.hdhhPK != null) || (this.hdhhPK != null && !this.hdhhPK.equals(other.hdhhPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.Hdhh[ idhh=" + hdhhPK.getIdHd() + ", idhd=" + hdhhPK.getIdHh() + ", count= " + count + " ]";
    }
    
}
