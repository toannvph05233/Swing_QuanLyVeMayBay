/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

/**
 *
 * @author johntoan98gmail.com
 */

import com.project.models.TaiKhoan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO {

   // Thêm tài khoản mới và trả về TaiKhoanID vừa được tạo
public int insertTaiKhoan(TaiKhoan taiKhoan) throws SQLException {
    String query = "INSERT INTO TaiKhoan (RoleID, TenDangNhap, MatKhau, TrangThai) VALUES (?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setInt(1, taiKhoan.getRoleID());
        stmt.setString(2, taiKhoan.getTenDangNhap());
        stmt.setString(3, taiKhoan.getMatKhau());
        stmt.setBoolean(4, taiKhoan.isTrangThai());
        stmt.executeUpdate();

        // Lấy TaiKhoanID mới được tạo
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys != null && generatedKeys.next()) { // Kiểm tra dòng hợp lệ
                return generatedKeys.getInt(1); // Trả về TaiKhoanID mới
            } else {
                throw new SQLException("Không thể lấy TaiKhoanID vừa được tạo. ResultSet trống.");
            }
        }
    }
}



    // Get all accounts
    public List<TaiKhoan> getAllTaiKhoan() throws SQLException {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        String query = "SELECT * FROM TaiKhoan where roleid != 1";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(
                        rs.getInt("TaiKhoanID"),
                        rs.getInt("RoleID"),
                        rs.getString("TenDangNhap"),
                        rs.getString("MatKhau"),
                        rs.getBoolean("TrangThai")
                );
                taiKhoans.add(taiKhoan);
            }
        }
        return taiKhoans;
    }

    // Update an existing account
    public void updateTaiKhoan(TaiKhoan taiKhoan) throws SQLException {
        String query = "UPDATE TaiKhoan SET RoleID = ?, TenDangNhap = ?, MatKhau = ?, TrangThai = ? WHERE TaiKhoanID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, taiKhoan.getRoleID());
            stmt.setString(2, taiKhoan.getTenDangNhap());
            stmt.setString(3, taiKhoan.getMatKhau());
            stmt.setBoolean(4, taiKhoan.isTrangThai());
            stmt.setInt(5, taiKhoan.getTaiKhoanID());
            stmt.executeUpdate();
        }
    }

    // Delete an account
    public void deleteTaiKhoan(int taiKhoanID) throws SQLException {
        String query = "DELETE FROM TaiKhoan WHERE TaiKhoanID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, taiKhoanID);
            stmt.executeUpdate();
        }
    }

    // Get account by ID
    public TaiKhoan getTaiKhoanByID(int taiKhoanID) throws SQLException {
        TaiKhoan taiKhoan = null;
        String query = "SELECT * FROM TaiKhoan WHERE TaiKhoanID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, taiKhoanID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    taiKhoan = new TaiKhoan(
                            rs.getInt("TaiKhoanID"),
                            rs.getInt("RoleID"),
                            rs.getString("TenDangNhap"),
                            rs.getString("MatKhau"),
                            rs.getBoolean("TrangThai")
                    );
                }
            }
        }
        return taiKhoan;
    }
    
     // Get account by ID
    public TaiKhoan login(String username, String password) throws SQLException {
        TaiKhoan taiKhoan = null;
        String query = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? and matkhau = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
             stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    taiKhoan = new TaiKhoan(
                            rs.getInt("TaiKhoanID"),
                            rs.getInt("RoleID"),
                            rs.getString("TenDangNhap"),
                            rs.getString("MatKhau"),
                            rs.getBoolean("TrangThai")
                    );
                }
            }
        }
        return taiKhoan;
    }
    
}

