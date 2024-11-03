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

public class TaiKhoan {
    private int taiKhoanID;
    private int roleID;
    private String tenDangNhap;
    private String matKhau;
    private boolean trangThai;

    public TaiKhoan(int taiKhoanID, int roleID, String tenDangNhap, String matKhau, boolean trangThai) {
        this.taiKhoanID = taiKhoanID;
        this.roleID = roleID;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }
public TaiKhoan( int roleID, String tenDangNhap, String matKhau, boolean trangThai) {
        this.roleID = roleID;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }
    // Getters and Setters
    public int getTaiKhoanID() {
        return taiKhoanID;
    }

    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
