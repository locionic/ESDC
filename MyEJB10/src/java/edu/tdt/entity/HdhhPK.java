/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author truonghongloc
 */
@Embeddable
public class HdhhPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hh", nullable = false)
    private long idHh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hd", nullable = false)
    private long idHd;

    public HdhhPK() {
    }

    public HdhhPK(long idHh, long idHd) {
        this.idHh = idHh;
        this.idHd = idHd;
    }

    public long getIdHh() {
        return idHh;
    }

    public void setIdHh(long idHh) {
        this.idHh = idHh;
    }

    public long getIdHd() {
        return idHd;
    }

    public void setIdHd(long idHd) {
        this.idHd = idHd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idHh;
        hash += (int) idHd;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HdhhPK)) {
            return false;
        }
        HdhhPK other = (HdhhPK) object;
        if (this.idHh != other.idHh) {
            return false;
        }
        if (this.idHd != other.idHd) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.HdhhPK[ idHh=" + idHh + ", idHd=" + idHd + " ]";
    }
    
}
