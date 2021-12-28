/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cong Dan
 */
@Entity
@Table(name = "tbl_DichVu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDichVu.findAll", query = "SELECT t FROM TblDichVu t")
    , @NamedQuery(name = "TblDichVu.findByMaDV", query = "SELECT t FROM TblDichVu t WHERE t.maDV = :maDV")
    , @NamedQuery(name = "TblDichVu.findByTenDichVu", query = "SELECT t FROM TblDichVu t WHERE t.tenDichVu = :tenDichVu")
    , @NamedQuery(name = "TblDichVu.findByGia", query = "SELECT t FROM TblDichVu t WHERE t.gia = :gia")})
public class TblDichVu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaDV")
    private Long maDV;
    @Column(name = "TenDichVu")
    private String tenDichVu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia")
    private Double gia;

    public TblDichVu() {
    }

    public TblDichVu(Long maDV) {
        this.maDV = maDV;
    }

    public Long getMaDV() {
        return maDV;
    }

    public void setMaDV(Long maDV) {
        this.maDV = maDV;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDV != null ? maDV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDichVu)) {
            return false;
        }
        TblDichVu other = (TblDichVu) object;
        if ((this.maDV == null && other.maDV != null) || (this.maDV != null && !this.maDV.equals(other.maDV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenDichVu;
    }

    public void setMaNhatKy(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMaSoThuCung(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNgay(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setBuoi(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTrangThai(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setGhiChu(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDichVu(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setThanhTien(float aFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
