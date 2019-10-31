/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.myentity;

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
public class HhPPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MaP", nullable = false)
    private long maP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaHH", nullable = false)
    private long maHH;

    public HhPPK() {
    }

    public HhPPK(long maP, long maHH) {
        this.maP = maP;
        this.maHH = maHH;
    }

    public long getMaP() {
        return maP;
    }

    public void setMaP(long maP) {
        this.maP = maP;
    }

    public long getMaHH() {
        return maHH;
    }

    public void setMaHH(long maHH) {
        this.maHH = maHH;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maP;
        hash += (int) maHH;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhPPK)) {
            return false;
        }
        HhPPK other = (HhPPK) object;
        if (this.maP != other.maP) {
            return false;
        }
        if (this.maHH != other.maHH) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.myentity.HhPPK[ maP=" + maP + ", maHH=" + maHH + " ]";
    }
    
}
