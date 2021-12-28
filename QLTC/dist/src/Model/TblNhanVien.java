/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cong Dan
 */
@Entity
@Table(name = "tbl_NhanVien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNhanVien.findAll", query = "SELECT t FROM TblNhanVien t")
    , @NamedQuery(name = "TblNhanVien.findByMaNV", query = "SELECT t FROM TblNhanVien t WHERE t.maNV = :maNV")
    , @NamedQuery(name = "TblNhanVien.findByTenNV", query = "SELECT t FROM TblNhanVien t WHERE t.tenNV = :tenNV")
    , @NamedQuery(name = "TblNhanVien.findByDiaChi", query = "SELECT t FROM TblNhanVien t WHERE t.diaChi = :diaChi")
    , @NamedQuery(name = "TblNhanVien.findByGioiTinh", query = "SELECT t FROM TblNhanVien t WHERE t.gioiTinh = :gioiTinh")
    , @NamedQuery(name = "TblNhanVien.findByNgaySinh", query = "SELECT t FROM TblNhanVien t WHERE t.ngaySinh = :ngaySinh")
    , @NamedQuery(name = "TblNhanVien.findByLoaiNV", query = "SELECT t FROM TblNhanVien t WHERE t.loaiNV = :loaiNV")
    , @NamedQuery(name = "TblNhanVien.findBySdt", query = "SELECT t FROM TblNhanVien t WHERE t.sdt = :sdt")
    , @NamedQuery(name = "TblNhanVien.findByHinhAnh", query = "SELECT t FROM TblNhanVien t WHERE t.hinhAnh = :hinhAnh")
    , @NamedQuery(name = "TblNhanVien.findByGhiChu", query = "SELECT t FROM TblNhanVien t WHERE t.ghiChu = :ghiChu")})
public class TblNhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaNV")
    private Long maNV;
    @Column(name = "TenNV")
    private String tenNV;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Column(name = "LoaiNV")
    private String loaiNV;
    @Column(name = "SDT")
    private Integer sdt;
    @Column(name = "HinhAnh")
    private String hinhAnh;
    @Column(name = "GhiChu")
    private String ghiChu;
    
   

    public TblNhanVien() {
    }

    public TblNhanVien(Long maNV) {
        this.maNV = maNV;
    }

    public Long getMaNV() {
        return maNV;
    }

    public void setMaNV(Long maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(String loaiNV) {
        this.loaiNV = loaiNV;
    }

    public Integer getSdt() {
        return sdt;
    }

    public void setSdt(Integer sdt) {
        this.sdt = sdt;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblNhanVien)) {
            return false;
        }
        TblNhanVien other = (TblNhanVien) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenNV;
    }
    
}
