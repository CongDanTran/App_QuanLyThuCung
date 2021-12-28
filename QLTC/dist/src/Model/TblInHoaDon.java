/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author CongDan
 */
public class TblInHoaDon {
    private Long maPhieuGui;
    private Long maKhachHang;
    private Date ngayGui;
    private Long maHinhThuc;
    private String TrangThai;
    private Long mathuCung;
    private Long maChuong;
    private InputStream hinhAnh;

    public TblInHoaDon(Long maPhieuGui, Long maKhachHang, Date ngayGui, Long maHinhThuc, String TrangThai, Long mathuCung, Long maChuong, InputStream hinhAnh) {
        this.maPhieuGui = maPhieuGui;
        this.maKhachHang = maKhachHang;
        this.ngayGui = ngayGui;
        this.maHinhThuc = maHinhThuc;
        this.TrangThai = TrangThai;
        this.mathuCung = mathuCung;
        this.maChuong = maChuong;
        this.hinhAnh = hinhAnh;
    }

    public TblInHoaDon() {
    }

    public Long getMaPhieuGui() {
        return maPhieuGui;
    }

    public void setMaPhieuGui(Long maPhieuGui) {
        this.maPhieuGui = maPhieuGui;
    }

    public Long getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Long maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Date getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(Date ngayGui) {
        this.ngayGui = ngayGui;
    }

    public Long getMaHinhThuc() {
        return maHinhThuc;
    }

    public void setMaHinhThuc(Long maHinhThuc) {
        this.maHinhThuc = maHinhThuc;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Long getMathuCung() {
        return mathuCung;
    }

    public void setMathuCung(Long mathuCung) {
        this.mathuCung = mathuCung;
    }

    public Long getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(Long maChuong) {
        this.maChuong = maChuong;
    }

    public InputStream getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(InputStream hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
}
