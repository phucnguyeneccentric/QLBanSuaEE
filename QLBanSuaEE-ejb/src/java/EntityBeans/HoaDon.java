/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hv
 */
@Entity
@Table(name = "hoa_don")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDon.findAll", query = "SELECT h FROM HoaDon h"),
    @NamedQuery(name = "HoaDon.findBySohoadon", query = "SELECT h FROM HoaDon h WHERE h.sohoadon = :sohoadon"),
    @NamedQuery(name = "HoaDon.findByNgayHD", query = "SELECT h FROM HoaDon h WHERE h.ngayHD = :ngayHD"),
    @NamedQuery(name = "HoaDon.findByMakhachhang", query = "SELECT h FROM HoaDon h WHERE h.makhachhang = :makhachhang"),
    @NamedQuery(name = "HoaDon.findByTrigia", query = "SELECT h FROM HoaDon h WHERE h.trigia = :trigia")})
public class HoaDon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "So_hoa_don")
    private String sohoadon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ngay_HD")
    @Temporal(TemporalType.DATE)
    private Date ngayHD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Ma_khach_hang")
    private String makhachhang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tri_gia")
    private double trigia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaDon")
    private List<CtHoadon> ctHoadonList;

    public HoaDon() {
    }

    public HoaDon(String sohoadon) {
        this.sohoadon = sohoadon;
    }

    public HoaDon(String sohoadon, Date ngayHD, String makhachhang, double trigia) {
        this.sohoadon = sohoadon;
        this.ngayHD = ngayHD;
        this.makhachhang = makhachhang;
        this.trigia = trigia;
    }

    public String getSohoadon() {
        return sohoadon;
    }

    public void setSohoadon(String sohoadon) {
        this.sohoadon = sohoadon;
    }

    public Date getNgayHD() {
        return ngayHD;
    }

    public void setNgayHD(Date ngayHD) {
        this.ngayHD = ngayHD;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public double getTrigia() {
        return trigia;
    }

    public void setTrigia(double trigia) {
        this.trigia = trigia;
    }

    @XmlTransient
    public List<CtHoadon> getCtHoadonList() {
        return ctHoadonList;
    }

    public void setCtHoadonList(List<CtHoadon> ctHoadonList) {
        this.ctHoadonList = ctHoadonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sohoadon != null ? sohoadon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.sohoadon == null && other.sohoadon != null) || (this.sohoadon != null && !this.sohoadon.equals(other.sohoadon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.HoaDon[ sohoadon=" + sohoadon + " ]";
    }
    
}
