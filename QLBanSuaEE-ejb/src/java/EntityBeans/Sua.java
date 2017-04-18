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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "sua")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sua.findAll", query = "SELECT s FROM Sua s"),
    @NamedQuery(name = "Sua.findByMasua", query = "SELECT s FROM Sua s WHERE s.masua = :masua"),
    @NamedQuery(name = "Sua.findByTensua", query = "SELECT s FROM Sua s WHERE s.tensua = :tensua"),
    @NamedQuery(name = "Sua.findByTrongluong", query = "SELECT s FROM Sua s WHERE s.trongluong = :trongluong"),
    @NamedQuery(name = "Sua.findByDongia", query = "SELECT s FROM Sua s WHERE s.dongia = :dongia"),
    @NamedQuery(name = "Sua.findByHinh", query = "SELECT s FROM Sua s WHERE s.hinh = :hinh")})
public class Sua implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "Ma_sua")
    private String masua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Ten_sua")
    private String tensua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Trong_luong")
    private int trongluong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Don_gia")
    private int dongia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "TP_Dinh_Duong")
    private String tPDinhDuong;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Loi_ich")
    private String loiich;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Hinh")
    private String hinh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sua")
    private List<CtHoadon> ctHoadonList;
    @JoinColumn(name = "Ma_loai_sua", referencedColumnName = "Ma_loai_sua")
    @ManyToOne(optional = false)
    private LoaiSua maloaisua;
    @JoinColumn(name = "Ma_hang_sua", referencedColumnName = "Ma_hang_sua")
    @ManyToOne(optional = false)
    private HangSua mahangsua;

    public Sua() {
    }

    public Sua(String masua) {
        this.masua = masua;
    }

    public Sua(String masua, String tensua, int trongluong, int dongia, String tPDinhDuong, String loiich, String hinh) {
        this.masua = masua;
        this.tensua = tensua;
        this.trongluong = trongluong;
        this.dongia = dongia;
        this.tPDinhDuong = tPDinhDuong;
        this.loiich = loiich;
        this.hinh = hinh;
    }

    public String getMasua() {
        return masua;
    }

    public void setMasua(String masua) {
        this.masua = masua;
    }

    public String getTensua() {
        return tensua;
    }

    public void setTensua(String tensua) {
        this.tensua = tensua;
    }

    public int getTrongluong() {
        return trongluong;
    }

    public void setTrongluong(int trongluong) {
        this.trongluong = trongluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getTPDinhDuong() {
        return tPDinhDuong;
    }

    public void setTPDinhDuong(String tPDinhDuong) {
        this.tPDinhDuong = tPDinhDuong;
    }

    public String getLoiich() {
        return loiich;
    }

    public void setLoiich(String loiich) {
        this.loiich = loiich;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @XmlTransient
    public List<CtHoadon> getCtHoadonList() {
        return ctHoadonList;
    }

    public void setCtHoadonList(List<CtHoadon> ctHoadonList) {
        this.ctHoadonList = ctHoadonList;
    }

    public LoaiSua getMaloaisua() {
        return maloaisua;
    }

    public void setMaloaisua(LoaiSua maloaisua) {
        this.maloaisua = maloaisua;
    }

    public HangSua getMahangsua() {
        return mahangsua;
    }

    public void setMahangsua(HangSua mahangsua) {
        this.mahangsua = mahangsua;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (masua != null ? masua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sua)) {
            return false;
        }
        Sua other = (Sua) object;
        if ((this.masua == null && other.masua != null) || (this.masua != null && !this.masua.equals(other.masua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.Sua[ masua=" + masua + " ]";
    }
    
}
