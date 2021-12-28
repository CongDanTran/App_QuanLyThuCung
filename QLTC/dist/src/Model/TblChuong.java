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
@Table(name = "tbl_Chuong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblChuong.findAll", query = "SELECT t FROM TblChuong t")
    , @NamedQuery(name = "TblChuong.findByMaChuong", query = "SELECT t FROM TblChuong t WHERE t.maChuong = :maChuong")
    , @NamedQuery(name = "TblChuong.findByTenChuong", query = "SELECT t FROM TblChuong t WHERE t.tenChuong = :tenChuong")
    , @NamedQuery(name = "TblChuong.findByLoaiChuong", query = "SELECT t FROM TblChuong t WHERE t.loaiChuong = :loaiChuong")
    , @NamedQuery(name = "TblChuong.findByGia", query = "SELECT t FROM TblChuong t WHERE t.gia = :gia")
    , @NamedQuery(name = "TblChuong.findByTrangThai", query = "SELECT t FROM TblChuong t WHERE t.trangThai = :trangThai")})
public class TblChuong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaChuong")
    private Long maChuong;
    @Column(name = "TenChuong")
    private String tenChuong;
    @Column(name = "LoaiChuong")
    private String loaiChuong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia")
    private Double gia;
    @Column(name = "TrangThai")
    private String trangThai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maChuong")
    private Collection<TblChiTietPhieuGui> tblChiTietPhieuGuiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maChuong")
    private Collection<TblDatCho> tblDatChoCollection;

    public TblChuong() {
    }

    public TblChuong(Long maChuong) {
        this.maChuong = maChuong;
    }

    public Long getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(Long maChuong) {
        this.maChuong = maChuong;
    }

    public String getTenChuong() {
        return tenChuong;
    }

    public void setTenChuong(String tenChuong) {
        this.tenChuong = tenChuong;
    }

    public String getLoaiChuong() {
        return loaiChuong;
    }

    public void setLoaiChuong(String loaiChuong) {
        this.loaiChuong = loaiChuong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @XmlTransient
    public Collection<TblChiTietPhieuGui> getTblChiTietPhieuGuiCollection() {
        return tblChiTietPhieuGuiCollection;
    }

    public void setTblChiTietPhieuGuiCollection(Collection<TblChiTietPhieuGui> tblChiTietPhieuGuiCollection) {
        this.tblChiTietPhieuGuiCollection = tblChiTietPhieuGuiCollection;
    }

    @XmlTransient
    public Collection<TblDatCho> getTblDatChoCollection() {
        return tblDatChoCollection;
    }

    public void setTblDatChoCollection(Collection<TblDatCho> tblDatChoCollection) {
        this.tblDatChoCollection = tblDatChoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maChuong != null ? maChuong.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblChuong)) {
            return false;
        }
        TblChuong other = (TblChuong) object;
        if ((this.maChuong == null && other.maChuong != null) || (this.maChuong != null && !this.maChuong.equals(other.maChuong))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenChuong;
    }
    
}
