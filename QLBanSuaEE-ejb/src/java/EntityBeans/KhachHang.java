/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hv
 */
@Entity
@Table(name = "khach_hang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k"),
    @NamedQuery(name = "KhachHang.findByMakhachhang", query = "SELECT k FROM KhachHang k WHERE k.makhachhang = :makhachhang"),
    @NamedQuery(name = "KhachHang.findByTenkhachhang", query = "SELECT k FROM KhachHang k WHERE k.tenkhachhang = :tenkhachhang"),
    @NamedQuery(name = "KhachHang.findByPhai", query = "SELECT k FROM KhachHang k WHERE k.phai = :phai"),
    @NamedQuery(name = "KhachHang.findByDiachi", query = "SELECT k FROM KhachHang k WHERE k.diachi = :diachi"),
    @NamedQuery(name = "KhachHang.findByDienthoai", query = "SELECT k FROM KhachHang k WHERE k.dienthoai = :dienthoai"),
    @NamedQuery(name = "KhachHang.findByEmail", query = "SELECT k FROM KhachHang k WHERE k.email = :email")})
public class KhachHang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Ma_khach_hang")
    private String makhachhang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Ten_khach_hang")
    private String tenkhachhang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Phai")
    private boolean phai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Dia_chi")
    private String diachi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Dien_thoai")
    private String dienthoai;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Email")
    private String email;

    public KhachHang() {
    }

    public KhachHang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public KhachHang(String makhachhang, String tenkhachhang, boolean phai, String diachi, String dienthoai, String email) {
        this.makhachhang = makhachhang;
        this.tenkhachhang = tenkhachhang;
        this.phai = phai;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.email = email;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public boolean getPhai() {
        return phai;
    }

    public void setPhai(boolean phai) {
        this.phai = phai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (makhachhang != null ? makhachhang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.makhachhang == null && other.makhachhang != null) || (this.makhachhang != null && !this.makhachhang.equals(other.makhachhang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.KhachHang[ makhachhang=" + makhachhang + " ]";
    }
    
}
