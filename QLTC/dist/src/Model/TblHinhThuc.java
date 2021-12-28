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
@Table(name = "tbl_HinhThuc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblHinhThuc.findAll", query = "SELECT t FROM TblHinhThuc t")
    , @NamedQuery(name = "TblHinhThuc.findByMaHinhThuc", query = "SELECT t FROM TblHinhThuc t WHERE t.maHinhThuc = :maHinhThuc")
    , @NamedQuery(name = "TblHinhThuc.findByLoai", query = "SELECT t FROM TblHinhThuc t WHERE t.loai = :loai")
    , @NamedQuery(name = "TblHinhThuc.findByGia", query = "SELECT t FROM TblHinhThuc t WHERE t.gia = :gia")})
public class TblHinhThuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaHinhThuc")
    private Long maHinhThuc;
    @Column(name = "Loai")
    private String loai;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia")
    private Double gia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maHinhThuc")
    private Collection<TblPhieuGui> tblPhieuGuiCollection;

    public TblHinhThuc() {
    }

    public TblHinhThuc(Long maHinhThuc) {
        this.maHinhThuc = maHinhThuc;
    }

    public Long getMaHinhThuc() {
        return maHinhThuc;
    }

    public void setMaHinhThuc(Long maHinhThuc) {
        this.maHinhThuc = maHinhThuc;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
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
        hash += (maHinhThuc != null ? maHinhThuc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblHinhThuc)) {
            return false;
        }
        TblHinhThuc other = (TblHinhThuc) object;
        if ((this.maHinhThuc == null && other.maHinhThuc != null) || (this.maHinhThuc != null && !this.maHinhThuc.equals(other.maHinhThuc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return loai;
    }
    
}
