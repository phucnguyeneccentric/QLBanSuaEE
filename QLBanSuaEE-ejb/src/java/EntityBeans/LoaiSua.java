/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hv
 */
@Entity
@Table(name = "loai_sua")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiSua.findAll", query = "SELECT l FROM LoaiSua l"),
    @NamedQuery(name = "LoaiSua.findByMaloaisua", query = "SELECT l FROM LoaiSua l WHERE l.maloaisua = :maloaisua"),
    @NamedQuery(name = "LoaiSua.findByTenloai", query = "SELECT l FROM LoaiSua l WHERE l.tenloai = :tenloai")})
public class LoaiSua implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Ma_loai_sua")
    private String maloaisua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Ten_loai")
    private String tenloai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maloaisua")
    private List<Sua> suaList;

    public LoaiSua() {
    }

    public LoaiSua(String maloaisua) {
        this.maloaisua = maloaisua;
    }

    public LoaiSua(String maloaisua, String tenloai) {
        this.maloaisua = maloaisua;
        this.tenloai = tenloai;
    }

    public String getMaloaisua() {
        return maloaisua;
    }

    public void setMaloaisua(String maloaisua) {
        this.maloaisua = maloaisua;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    @XmlTransient
    public List<Sua> getSuaList() {
        return suaList;
    }

    public void setSuaList(List<Sua> suaList) {
        this.suaList = suaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maloaisua != null ? maloaisua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiSua)) {
            return false;
        }
        LoaiSua other = (LoaiSua) object;
        if ((this.maloaisua == null && other.maloaisua != null) || (this.maloaisua != null && !this.maloaisua.equals(other.maloaisua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.LoaiSua[ maloaisua=" + maloaisua + " ]";
    }
    
}
