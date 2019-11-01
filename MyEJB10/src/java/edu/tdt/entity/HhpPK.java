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
public class HhpPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_p", nullable = false)
    private long idP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hh", nullable = false)
    private long idHh;

    public HhpPK() {
    }

    public HhpPK(long idP, long idHh) {
        this.idP = idP;
        this.idHh = idHh;
    }

    public long getIdP() {
        return idP;
    }

    public void setIdP(long idP) {
        this.idP = idP;
    }

    public long getIdHh() {
        return idHh;
    }

    public void setIdHh(long idHh) {
        this.idHh = idHh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idP;
        hash += (int) idHh;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhpPK)) {
            return false;
        }
        HhpPK other = (HhpPK) object;
        if (this.idP != other.idP) {
            return false;
        }
        if (this.idHh != other.idHh) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.HhpPK[ idP=" + idP + ", idHh=" + idHh + " ]";
    }
    
}
