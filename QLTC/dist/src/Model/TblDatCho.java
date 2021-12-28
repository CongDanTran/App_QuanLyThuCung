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
@Table(name = "tbl_DatCho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDatCho.findAll", query = "SELECT t FROM TblDatCho t")
    , @NamedQuery(name = "TblDatCho.findByMaDatCho", query = "SELECT t FROM TblDatCho t WHERE t.maDatCho = :maDatCho")
    , @NamedQuery(name = "TblDatCho.findByTenKhachHang", query = "SELECT t FROM TblDatCho t WHERE t.tenKhachHang = :tenKhachHang")
    , @NamedQuery(name = "TblDatCho.findBySdt", query = "SELECT t FROM TblDatCho t WHERE t.sdt = :sdt")
    , @NamedQuery(name = "TblDatCho.findByNgayDat", query = "SELECT t FROM TblDatCho t WHERE t.ngayDat = :ngayDat")
    , @NamedQuery(name = "TblDatCho.findByNgaySD", query = "SELECT t FROM TblDatCho t WHERE t.ngaySD = :ngaySD")
    , @NamedQuery(name = "TblDatCho.findBySoLuong", query = "SELECT t FROM TblDatCho t WHERE t.soLuong = :soLuong")})
public class TblDatCho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaDatCho")
    private Long maDatCho;
    @Column(name = "TenKhachHang")
    private String tenKhachHang;
    @Column(name = "SDT")
    private Integer sdt;
    @Column(name = "NgayDat")
    @Temporal(TemporalType.DATE)
    private Date ngayDat;
    @Column(name = "NgaySD")
    @Temporal(TemporalType.DATE)
    private Date ngaySD;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @JoinColumn(name = "MaChuong", referencedColumnName = "MaChuong")
    @ManyToOne(optional = false)
    private Long maChuong;
    private String tenChuong;

    public String getTenChuong() {
        return tenChuong;
    }

    public void setTenChuong(String tenChuong) {
        this.tenChuong = tenChuong;
    }

    public TblDatCho() {
    }

    public TblDatCho(Long maDatCho) {
        this.maDatCho = maDatCho;
    }

    public Long getMaDatCho() {
        return maDatCho;
    }

    public void setMaDatCho(Long maDatCho) {
        this.maDatCho = maDatCho;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Integer getSdt() {
        return sdt;
    }

    public void setSdt(Integer sdt) {
        this.sdt = sdt;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getNgaySD() {
        return ngaySD;
    }

    public void setNgaySD(Date ngaySD) {
        this.ngaySD = ngaySD;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public long getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(long maChuong) {
        this.maChuong = maChuong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDatCho != null ? maDatCho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDatCho)) {
            return false;
        }
        TblDatCho other = (TblDatCho) object;
        if ((this.maDatCho == null && other.maDatCho != null) || (this.maDatCho != null && !this.maDatCho.equals(other.maDatCho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TblDatCho[ maDatCho=" + maDatCho + " ]";
    }
    
}
