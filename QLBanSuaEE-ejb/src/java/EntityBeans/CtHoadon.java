/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

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
 * @author hv
 */
@Entity
@Table(name = "ct_hoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtHoadon.findAll", query = "SELECT c FROM CtHoadon c"),
    @NamedQuery(name = "CtHoadon.findBySohoadon", query = "SELECT c FROM CtHoadon c WHERE c.ctHoadonPK.sohoadon = :sohoadon"),
    @NamedQuery(name = "CtHoadon.findByMasua", query = "SELECT c FROM CtHoadon c WHERE c.ctHoadonPK.masua = :masua"),
    @NamedQuery(name = "CtHoadon.findBySoluong", query = "SELECT c FROM CtHoadon c WHERE c.soluong = :soluong"),
    @NamedQuery(name = "CtHoadon.findByDongia", query = "SELECT c FROM CtHoadon c WHERE c.dongia = :dongia")})
public class CtHoadon implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CtHoadonPK ctHoadonPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "So_luong")
    private int soluong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Don_gia")
    private int dongia;
    @JoinColumn(name = "Ma_sua", referencedColumnName = "Ma_sua", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sua sua;
    @JoinColumn(name = "So_hoa_don", referencedColumnName = "So_hoa_don", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HoaDon hoaDon;

    public CtHoadon() {
    }

    public CtHoadon(CtHoadonPK ctHoadonPK) {
        this.ctHoadonPK = ctHoadonPK;
    }

    public CtHoadon(CtHoadonPK ctHoadonPK, int soluong, int dongia) {
        this.ctHoadonPK = ctHoadonPK;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public CtHoadon(String sohoadon, String masua) {
        this.ctHoadonPK = new CtHoadonPK(sohoadon, masua);
    }

    public CtHoadonPK getCtHoadonPK() {
        return ctHoadonPK;
    }

    public void setCtHoadonPK(CtHoadonPK ctHoadonPK) {
        this.ctHoadonPK = ctHoadonPK;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public Sua getSua() {
        return sua;
    }

    public void setSua(Sua sua) {
        this.sua = sua;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctHoadonPK != null ? ctHoadonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtHoadon)) {
            return false;
        }
        CtHoadon other = (CtHoadon) object;
        if ((this.ctHoadonPK == null && other.ctHoadonPK != null) || (this.ctHoadonPK != null && !this.ctHoadonPK.equals(other.ctHoadonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.CtHoadon[ ctHoadonPK=" + ctHoadonPK + " ]";
    }
    
}
