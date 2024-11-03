/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.models;
import java.time.LocalDate;

/**
 *
 * @author johntoan98gmail.com
 */
public class KhachHang {
    private Integer khachHangID;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private LocalDate ngaySinh;

    public KhachHang(Integer khachHangID, String hoTen, String soDienThoai, String email, String diaChi, LocalDate ngaySinh) {
        this.khachHangID = khachHangID;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
    }

    

    public KhachHang() {
    }

    public Integer getKhachHangID() {
        return khachHangID;
    }

    public void setKhachHangID(Integer khachHangID) {
        this.khachHangID = khachHangID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    
    
    
}
