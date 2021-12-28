/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cong Dan
 */
@Entity
@Table(name = "tbl_KhachHang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblKhachHang.findAll", query = "SELECT t FROM TblKhachHang t")
    , @NamedQuery(name = "TblKhachHang.findByMaKH", query = "SELECT t FROM TblKhachHang t WHERE t.maKH = :maKH")
    , @NamedQuery(name = "TblKhachHang.findByTenKH", query = "SELECT t FROM TblKhachHang t WHERE t.tenKH = :tenKH")
    , @NamedQuery(name = "TblKhachHang.findByDiaChi", query = "SELECT t FROM TblKhachHang t WHERE t.diaChi = :diaChi")
    , @NamedQuery(name = "TblKhachHang.findBySdt", query = "SELECT t FROM TblKhachHang t WHERE t.sdt = :sdt")
    , @NamedQuery(name = "TblKhachHang.findByLoai", query = "SELECT t FROM TblKhachHang t WHERE t.loai = :loai")})
public class TblKhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaKH")
    private Long maKH;
    @Column(name = "TenKH")
    private String tenKH;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "SDT")
    private Integer sdt;
    @Column(name = "Loai")
    private String loai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maKH")
    private Collection<TblThuCungKyGui> tblThuCungKyGuiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maKH")
    private Collection<TblPhieuGui> tblPhieuGuiCollection;

    public TblKhachHang() {
    }

    public TblKhachHang(Long maKH) {
        this.maKH = maKH;
    }

    public Long getMaKH() {
        return maKH;
    }

    public void setMaKH(Long maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getSdt() {
        return sdt;
    }

    public void setSdt(Integer sdt) {
        this.sdt = sdt;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    @XmlTransient
    public Collection<TblThuCungKyGui> getTblThuCungKyGuiCollection() {
        return tblThuCungKyGuiCollection;
    }

    public void setTblThuCungKyGuiCollection(Collection<TblThuCungKyGui> tblThuCungKyGuiCollection) {
        this.tblThuCungKyGuiCollection = tblThuCungKyGuiCollection;
    }

    @XmlTransient
    public Collection<TblPhieuGui> getTblPhieuGuiCollection() {
        return tblPhieuGuiCollection;
    }

    public void setTblPhieuGuiCollection(Collection<TblPhieuGui> tblPhieuGuiCollection) {
        this.tblPhieuGuiCollection = tblPhieuGuiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKH != null ? maKH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblKhachHang)) {
            return false;
        }
        TblKhachHang other = (TblKhachHang) object;
        if ((this.maKH == null && other.maKH != null) || (this.maKH != null && !this.maKH.equals(other.maKH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenKH;
    }
    
}
