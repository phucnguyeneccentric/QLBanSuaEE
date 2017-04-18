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
@Table(name = "hang_sua")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HangSua.findAll", query = "SELECT h FROM HangSua h"),
    @NamedQuery(name = "HangSua.findByMahangsua", query = "SELECT h FROM HangSua h WHERE h.mahangsua = :mahangsua"),
    @NamedQuery(name = "HangSua.findByTenhangsua", query = "SELECT h FROM HangSua h WHERE h.tenhangsua = :tenhangsua"),
    @NamedQuery(name = "HangSua.findByDiachi", query = "SELECT h FROM HangSua h WHERE h.diachi = :diachi"),
    @NamedQuery(name = "HangSua.findByDienthoai", query = "SELECT h FROM HangSua h WHERE h.dienthoai = :dienthoai"),
    @NamedQuery(name = "HangSua.findByEmail", query = "SELECT h FROM HangSua h WHERE h.email = :email")})
public class HangSua implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Ma_hang_sua")
    private String mahangsua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Ten_hang_sua")
    private String tenhangsua;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mahangsua")
    private List<Sua> suaList;

    public HangSua() {
    }

    public HangSua(String mahangsua) {
        this.mahangsua = mahangsua;
    }

    public HangSua(String mahangsua, String tenhangsua, String diachi, String dienthoai, String email) {
        this.mahangsua = mahangsua;
        this.tenhangsua = tenhangsua;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.email = email;
    }

    public String getMahangsua() {
        return mahangsua;
    }

    public void setMahangsua(String mahangsua) {
        this.mahangsua = mahangsua;
    }

    public String getTenhangsua() {
        return tenhangsua;
    }

    public void setTenhangsua(String tenhangsua) {
        this.tenhangsua = tenhangsua;
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
        hash += (mahangsua != null ? mahangsua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HangSua)) {
            return false;
        }
        HangSua other = (HangSua) object;
        if ((this.mahangsua == null && other.mahangsua != null) || (this.mahangsua != null && !this.mahangsua.equals(other.mahangsua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.HangSua[ mahangsua=" + mahangsua + " ]";
    }
    
}
