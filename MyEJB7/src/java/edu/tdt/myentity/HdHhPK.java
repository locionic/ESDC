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
public class HdHhPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MaHH", nullable = false)
    private long maHH;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaHD", nullable = false)
    private long maHD;

    public HdHhPK() {
    }

    public HdHhPK(long maHH, long maHD) {
        this.maHH = maHH;
        this.maHD = maHD;
    }

    public long getMaHH() {
        return maHH;
    }

    public void setMaHH(long maHH) {
        this.maHH = maHH;
    }

    public long getMaHD() {
        return maHD;
    }

    public void setMaHD(long maHD) {
        this.maHD = maHD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maHH;
        hash += (int) maHD;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HdHhPK)) {
            return false;
        }
        HdHhPK other = (HdHhPK) object;
        if (this.maHH != other.maHH) {
            return false;
        }
        if (this.maHD != other.maHD) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.myentity.HdHhPK[ maHH=" + maHH + ", maHD=" + maHD + " ]";
    }
    
}
