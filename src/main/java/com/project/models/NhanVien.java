/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.models;

/**
 *
 * @author johntoan98gmail.com
 */

public class NhanVien {
    private int nhanVienId;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private int TaiKhoanID;

    // Constructors, getters, setters
    public NhanVien(int nhanVienId, String hoTen, String soDienThoai, String email, String diaChi) {
        this.nhanVienId = nhanVienId;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public NhanVien(int nhanVienId, String hoTen, String soDienThoai, String email, String diaChi, int TaiKhoanID) {
        this.nhanVienId = nhanVienId;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.TaiKhoanID = TaiKhoanID;
    }
    
    

    public int getTaiKhoanID() {
        return TaiKhoanID;
    }

    public void setTaiKhoanID(int TaiKhoanID) {
        this.TaiKhoanID = TaiKhoanID;
    }

    
    
    
    public int getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(int nhanVienId) {
        this.nhanVienId = nhanVienId;
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

    
}

