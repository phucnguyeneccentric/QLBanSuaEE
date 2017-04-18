/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hv
 */
@Embeddable
public class CtHoadonPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "So_hoa_don")
    private String sohoadon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "Ma_sua")
    private String masua;

    public CtHoadonPK() {
    }

    public CtHoadonPK(String sohoadon, String masua) {
        this.sohoadon = sohoadon;
        this.masua = masua;
    }

    public String getSohoadon() {
        return sohoadon;
    }

    public void setSohoadon(String sohoadon) {
        this.sohoadon = sohoadon;
    }

    public String getMasua() {
        return masua;
    }

    public void setMasua(String masua) {
        this.masua = masua;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sohoadon != null ? sohoadon.hashCode() : 0);
        hash += (masua != null ? masua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtHoadonPK)) {
            return false;
        }
        CtHoadonPK other = (CtHoadonPK) object;
        if ((this.sohoadon == null && other.sohoadon != null) || (this.sohoadon != null && !this.sohoadon.equals(other.sohoadon))) {
            return false;
        }
        if ((this.masua == null && other.masua != null) || (this.masua != null && !this.masua.equals(other.masua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.CtHoadonPK[ sohoadon=" + sohoadon + ", masua=" + masua + " ]";
    }
    
}
