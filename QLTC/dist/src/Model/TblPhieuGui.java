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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_PhieuGui")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPhieuGui.findAll", query = "SELECT t FROM TblPhieuGui t")
    , @NamedQuery(name = "TblPhieuGui.findByMaPhieuGui", query = "SELECT t FROM TblPhieuGui t WHERE t.maPhieuGui = :maPhieuGui")
    , @NamedQuery(name = "TblPhieuGui.findByNgayGui", query = "SELECT t FROM TblPhieuGui t WHERE t.ngayGui = :ngayGui")
    , @NamedQuery(name = "TblPhieuGui.findByTrangThai", query = "SELECT t FROM TblPhieuGui t WHERE t.trangThai = :trangThai")})
public class TblPhieuGui implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaPhieuGui")
    private Long maPhieuGui;
    @Column(name = "NgayGui")
    @Temporal(TemporalType.DATE)
    private Date ngayGui;
    @Column(name = "TrangThai")
    private String trangThai;
  
   
    @JoinColumn(name = "MaHinhThuc", referencedColumnName = "MaHinhThuc")
    @ManyToOne(optional = false)
    private Long maHinhThuc;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne(optional = false)
    private Long maKH;
    private String loai;
    private String tenKH;
    private float tongTien;
    private Long maThuCung;
    private Long maChuong;

    public long getMaThuCung() {
        return maThuCung;
    }

    public void setMaThuCung(long maThuCung) {
        this.maThuCung = maThuCung;
    }

    public long getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(long maChuong) {
        this.maChuong = maChuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public TblPhieuGui() {
    }

    public TblPhieuGui(Long maPhieuGui) {
        this.maPhieuGui = maPhieuGui;
    }

    public Long getMaPhieuGui() {
        return maPhieuGui;
    }

    public void setMaPhieuGui(Long maPhieuGui) {
        this.maPhieuGui = maPhieuGui;
    }

    public Date getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(Date ngayGui) {
        this.ngayGui = ngayGui;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

  

    public long getMaHinhThuc() {
        return maHinhThuc;
    }

    public void setMaHinhThuc(long maHinhThuc) {
        this.maHinhThuc = maHinhThuc;
    }

    public long getMaKH() {
        return maKH;
    }

    public void setMaKH(long maKH) {
        this.maKH = maKH;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPhieuGui != null ? maPhieuGui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPhieuGui)) {
            return false;
        }
        TblPhieuGui other = (TblPhieuGui) object;
        if ((this.maPhieuGui == null && other.maPhieuGui != null) || (this.maPhieuGui != null && !this.maPhieuGui.equals(other.maPhieuGui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TblPhieuGui[ maPhieuGui=" + maPhieuGui + " ]";
    }
    
}
