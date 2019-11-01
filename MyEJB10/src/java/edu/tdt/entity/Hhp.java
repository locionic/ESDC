/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

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
@Table(name = "hhp", catalog = "MyEJB10", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hhp.findAll", query = "SELECT h FROM Hhp h")
    , @NamedQuery(name = "Hhp.findByIdP", query = "SELECT h FROM Hhp h WHERE h.hhpPK.idP = :idP")
    , @NamedQuery(name = "Hhp.findByIdHh", query = "SELECT h FROM Hhp h WHERE h.hhpPK.idHh = :idHh")
    , @NamedQuery(name = "Hhp.findByStartdate", query = "SELECT h FROM Hhp h WHERE h.startdate = :startdate")
    , @NamedQuery(name = "Hhp.findByEnddate", query = "SELECT h FROM Hhp h WHERE h.enddate = :enddate")
    , @NamedQuery(name = "Hhp.findByCount", query = "SELECT h FROM Hhp h WHERE h.count = :count")})
public class Hhp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HhpPK hhpPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count", nullable = false)
    private long count;
    @JoinColumn(name = "id_hh", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hanghoa hanghoa;
    @JoinColumn(name = "id_p", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Phieu phieu;

    public Hhp() {
    }

    public Hhp(HhpPK hhpPK) {
        this.hhpPK = hhpPK;
    }

    public Hhp(HhpPK hhpPK, Date startdate, Date enddate, long count) {
        this.hhpPK = hhpPK;
        this.startdate = startdate;
        this.enddate = enddate;
        this.count = count;
    }

    public Hhp(long idP, long idHh) {
        this.hhpPK = new HhpPK(idP, idHh);
    }

    public HhpPK getHhpPK() {
        return hhpPK;
    }

    public void setHhpPK(HhpPK hhpPK) {
        this.hhpPK = hhpPK;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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

    public Phieu getPhieu() {
        return phieu;
    }

    public void setPhieu(Phieu phieu) {
        this.phieu = phieu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hhpPK != null ? hhpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hhp)) {
            return false;
        }
        Hhp other = (Hhp) object;
        if ((this.hhpPK == null && other.hhpPK != null) || (this.hhpPK != null && !this.hhpPK.equals(other.hhpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.Hhp[ hhpPK=" + hhpPK + " ]";
    }
    
}
