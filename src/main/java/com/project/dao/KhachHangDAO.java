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
import com.project.models.KhachHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {
    public KhachHang findById(int id) throws SQLException {
        String sql = "SELECT * FROM KhachHang WHERE KhachHangID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapRowToKhachHang(rs);
            }
        }
        return null;
    }
public List<KhachHang> findByName(String name) throws SQLException {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang WHERE HoTen LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(mapRowToKhachHang(rs));
            }
        }
        return list;
    }
    public List<KhachHang> findAll() throws SQLException {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRowToKhachHang(rs));
            }
        }
        return list;
    }

    public void save(KhachHang khachHang) throws SQLException {
        String sql = "INSERT INTO KhachHang (HoTen, SoDienThoai, Email, DiaChi, NgaySinh) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, khachHang.getHoTen());
            stmt.setString(2, khachHang.getSoDienThoai());
            stmt.setString(3, khachHang.getEmail());
            stmt.setString(4, khachHang.getDiaChi());
            stmt.setDate(5, Date.valueOf(khachHang.getNgaySinh()));
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                khachHang.setKhachHangID(rs.getInt(1));
            }
        }
    }

    public void update(KhachHang khachHang) throws SQLException {
        String sql = "UPDATE KhachHang SET HoTen = ?, SoDienThoai = ?, Email = ?, DiaChi = ?, NgaySinh = ? WHERE KhachHangID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, khachHang.getHoTen());
            stmt.setString(2, khachHang.getSoDienThoai());
            stmt.setString(3, khachHang.getEmail());
            stmt.setString(4, khachHang.getDiaChi());
            stmt.setDate(5, Date.valueOf(khachHang.getNgaySinh()));
            stmt.setInt(6, khachHang.getKhachHangID());
            stmt.executeUpdate();
        }
    }

    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM KhachHang WHERE KhachHangID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private KhachHang mapRowToKhachHang(ResultSet rs) throws SQLException {
        KhachHang khachHang = new KhachHang();
        khachHang.setKhachHangID(rs.getInt("KhachHangID"));
        khachHang.setHoTen(rs.getString("HoTen"));
        khachHang.setSoDienThoai(rs.getString("SoDienThoai"));
        khachHang.setEmail(rs.getString("Email"));
        khachHang.setDiaChi(rs.getString("DiaChi"));
        khachHang.setNgaySinh(rs.getDate("NgaySinh").toLocalDate());
        return khachHang;
    }
}

