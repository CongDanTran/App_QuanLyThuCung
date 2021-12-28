/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.InputStream;

/**
 *
 * @author CongDan
 */
public class ReportPhieuGui {
    String tenKhachHang,hinhThuc,chuong;
    String ngayGui;
    InputStream image;
    Long maPhieuGui,maThuCung;

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getChuong() {
        return chuong;
    }

    public void setChuong(String chuong) {
        this.chuong = chuong;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public Long getMaPhieuGui() {
        return maPhieuGui;
    }

    public void setMaPhieuGui(long maPhieuGui) {
        this.maPhieuGui = maPhieuGui;
    }

    public Long getMaThuCung() {
        return maThuCung;
    }

    public void setMaThuCung(long maThuCung) {
        this.maThuCung = maThuCung;
    }
}
