/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cong Dan
 */
@Entity
@Table(name = "tbl_NhatKyNuoi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNhatKyNuoi.findAll", query = "SELECT t FROM TblNhatKyNuoi t")
    , @NamedQuery(name = "TblNhatKyNuoi.findByMaNhatKy", query = "SELECT t FROM TblNhatKyNuoi t WHERE t.maNhatKy = :maNhatKy")
    , @NamedQuery(name = "TblNhatKyNuoi.findByNgay", query = "SELECT t FROM TblNhatKyNuoi t WHERE t.ngay = :ngay")
    , @NamedQuery(name = "TblNhatKyNuoi.findByBuoi", query = "SELECT t FROM TblNhatKyNuoi t WHERE t.buoi = :buoi")
    , @NamedQuery(name = "TblNhatKyNuoi.findByHoatDong", query = "SELECT t FROM TblNhatKyNuoi t WHERE t.hoatDong = :hoatDong")
    , @NamedQuery(name = "TblNhatKyNuoi.findByTrangThai", query = "SELECT t FROM TblNhatKyNuoi t WHERE t.trangThai = :trangThai")
    , @NamedQuery(name = "TblNhatKyNuoi.findByGhiChu", query = "SELECT t FROM TblNhatKyNuoi t WHERE t.ghiChu = :ghiChu")})
public class TblNhatKyNuoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaNhatKy")
    private Long maNhatKy;
    @Column(name = "Ngay")
    @Temporal(TemporalType.DATE)
    private Date ngay;
    @Column(name = "Buoi")
    private String buoi;
    @Column(name = "HoatDong")
    private String hoatDong;
    @Column(name = "TrangThai")
    private String trangThai;
    @Column(name = "GhiChu")
    private String ghiChu;
    @JoinColumn(name = "MaSoThuCung", referencedColumnName = "MaSoThuCung")
    @ManyToOne(optional = false)
    private Long maSoThuCung;
    private String dichVu;
    private float thanhTien;
    private String giong;

    public String getGiong() {
        return giong;
    }

    public void setGiong(String giong) {
        this.giong = giong;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public TblNhatKyNuoi() {
    }

    public TblNhatKyNuoi(Long maNhatKy) {
        this.maNhatKy = maNhatKy;
    }

    public Long getMaNhatKy() {
        return maNhatKy;
    }

    public void setMaNhatKy(Long maNhatKy) {
        this.maNhatKy = maNhatKy;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getBuoi() {
        return buoi;
    }

    public void setBuoi(String buoi) {
        this.buoi = buoi;
    }

    public String getHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(String hoatDong) {
        this.hoatDong = hoatDong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public long getMaSoThuCung() {
        return maSoThuCung;
    }

    public void setMaSoThuCung(long maSoThuCung) {
        this.maSoThuCung = maSoThuCung;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNhatKy != null ? maNhatKy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblNhatKyNuoi)) {
            return false;
        }
        TblNhatKyNuoi other = (TblNhatKyNuoi) object;
        if ((this.maNhatKy == null && other.maNhatKy != null) || (this.maNhatKy != null && !this.maNhatKy.equals(other.maNhatKy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TblNhatKyNuoi[ maNhatKy=" + maNhatKy + " ]";
    }
    
}
