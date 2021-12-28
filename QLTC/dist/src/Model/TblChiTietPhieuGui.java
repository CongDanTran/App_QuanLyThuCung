/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cong Dan
 */
@Entity
@Table(name = "tbl_ChiTietPhieuGui")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblChiTietPhieuGui.findAll", query = "SELECT t FROM TblChiTietPhieuGui t")
    , @NamedQuery(name = "TblChiTietPhieuGui.findByMaPhieuGui", query = "SELECT t FROM TblChiTietPhieuGui t WHERE t.tblChiTietPhieuGuiPK.maPhieuGui = :maPhieuGui")
    , @NamedQuery(name = "TblChiTietPhieuGui.findByMaSoThuCung", query = "SELECT t FROM TblChiTietPhieuGui t WHERE t.tblChiTietPhieuGuiPK.maSoThuCung = :maSoThuCung")
    , @NamedQuery(name = "TblChiTietPhieuGui.findByDichVu", query = "SELECT t FROM TblChiTietPhieuGui t WHERE t.dichVu = :dichVu")})
public class TblChiTietPhieuGui implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @Column(name = "DichVu")
    private String dichVu;
    @JoinColumn(name = "MaChuong", referencedColumnName = "MaChuong")
    @ManyToOne(optional = false)
    private Long maChuong;
    @JoinColumn(name = "MaSoThuCung", referencedColumnName = "MaSoThuCung", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Long maSoThuCung;
    private Long maPhieuGui;
    private String tenChuong;
    private float tongTien;
    private String giong;

    public String getGiong() {
        return giong;
    }

    public void setGiong(String giong) {
        this.giong = giong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getTenChuong() {
        return tenChuong;
    }

    public void setTenChuong(String tenChuong) {
        this.tenChuong = tenChuong;
    }

    public TblChiTietPhieuGui() {
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public long getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(long maChuong) {
        this.maChuong = maChuong;
    }

    public long getmaSoThuCung() {
        return maSoThuCung;
    }

    public void setmaSoThuCung(long maSoThuCung) {
        this.maSoThuCung = maSoThuCung;
    }
    public long getMaPhieuGui() {
        return maPhieuGui;
    }

    public void setMaPhieuGui(long maPhieuGui) {
        this.maPhieuGui = maPhieuGui;
    }
}
