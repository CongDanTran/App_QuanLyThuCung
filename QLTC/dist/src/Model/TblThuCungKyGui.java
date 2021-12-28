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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_ThuCungKyGui")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblThuCungKyGui.findAll", query = "SELECT t FROM TblThuCungKyGui t")
    , @NamedQuery(name = "TblThuCungKyGui.findByMaSoThuCung", query = "SELECT t FROM TblThuCungKyGui t WHERE t.maSoThuCung = :maSoThuCung")
    , @NamedQuery(name = "TblThuCungKyGui.findByGiong", query = "SELECT t FROM TblThuCungKyGui t WHERE t.giong = :giong")
    , @NamedQuery(name = "TblThuCungKyGui.findByLoai", query = "SELECT t FROM TblThuCungKyGui t WHERE t.loai = :loai")
    , @NamedQuery(name = "TblThuCungKyGui.findByCanNang", query = "SELECT t FROM TblThuCungKyGui t WHERE t.canNang = :canNang")
    , @NamedQuery(name = "TblThuCungKyGui.findByTinhTrangSK", query = "SELECT t FROM TblThuCungKyGui t WHERE t.tinhTrangSK = :tinhTrangSK")
    , @NamedQuery(name = "TblThuCungKyGui.findByHinhAnh", query = "SELECT t FROM TblThuCungKyGui t WHERE t.hinhAnh = :hinhAnh")})
public class TblThuCungKyGui implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaSoThuCung")
    private Long maSoThuCung;
    @Column(name = "Giong")
    private String giong;
    @Column(name = "Loai")
    private String loai;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CanNang")
    private Double canNang;
    @Column(name = "TinhTrangSK")
    private String tinhTrangSK;
    @Column(name = "HinhAnh")
    private String hinhAnh;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne(optional = false)
    private Long maKH;
    private String tenKH;
    private String trangThai;

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblThuCungKyGui")
    private Collection<TblChiTietPhieuGui> tblChiTietPhieuGuiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maSoThuCung")
    private Collection<TblNhatKyNuoi> tblNhatKyNuoiCollection;

    public TblThuCungKyGui() {
    }

    public TblThuCungKyGui(Long maSoThuCung) {
        this.maSoThuCung = maSoThuCung;
    }

    public Long getMaSoThuCung() {
        return maSoThuCung;
    }

    public void setMaSoThuCung(Long maSoThuCung) {
        this.maSoThuCung = maSoThuCung;
    }

    public String getGiong() {
        return giong;
    }

    public void setGiong(String giong) {
        this.giong = giong;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Double getCanNang() {
        return canNang;
    }

    public void setCanNang(Double canNang) {
        this.canNang = canNang;
    }

    public String getTinhTrangSK() {
        return tinhTrangSK;
    }

    public void setTinhTrangSK(String tinhTrangSK) {
        this.tinhTrangSK = tinhTrangSK;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public long getMaKH() {
        return maKH;
    }

    public void setMaKH(long maKH) {
        this.maKH = maKH;
    }

    @XmlTransient
    public Collection<TblChiTietPhieuGui> getTblChiTietPhieuGuiCollection() {
        return tblChiTietPhieuGuiCollection;
    }

    public void setTblChiTietPhieuGuiCollection(Collection<TblChiTietPhieuGui> tblChiTietPhieuGuiCollection) {
        this.tblChiTietPhieuGuiCollection = tblChiTietPhieuGuiCollection;
    }

    @XmlTransient
    public Collection<TblNhatKyNuoi> getTblNhatKyNuoiCollection() {
        return tblNhatKyNuoiCollection;
    }

    public void setTblNhatKyNuoiCollection(Collection<TblNhatKyNuoi> tblNhatKyNuoiCollection) {
        this.tblNhatKyNuoiCollection = tblNhatKyNuoiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSoThuCung != null ? maSoThuCung.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblThuCungKyGui)) {
            return false;
        }
        TblThuCungKyGui other = (TblThuCungKyGui) object;
        if ((this.maSoThuCung == null && other.maSoThuCung != null) || (this.maSoThuCung != null && !this.maSoThuCung.equals(other.maSoThuCung))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return giong;
    }
}
