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
import com.project.models.LichBay;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LichBayDAO {
    public LichBay findById(int id) throws SQLException {
        String sql = "SELECT * FROM LichBay WHERE LichBayID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapRowToLichBay(rs);
            }
        }
        return null;
    }
    public List<LichBay> findByDate(LocalDate date) throws SQLException {
        List<LichBay> list = new ArrayList<>();
        String sql = "SELECT * FROM LichBay WHERE CAST(NgayGioBay AS DATE) = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(date));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(mapRowToLichBay(rs));
            }
        }
        return list;
    }

    public List<LichBay> findAll() throws SQLException {
        List<LichBay> list = new ArrayList<>();
        String sql = "SELECT * FROM LichBay";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRowToLichBay(rs));
            }
        }
        return list;
    }

    public void save(LichBay lichBay) throws SQLException {
        String sql = "INSERT INTO LichBay (MaChuyenBay, NoiDi, NoiDen, NgayGioBay, SoGhe, GiaVe) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, lichBay.getMaChuyenBay());
            stmt.setString(2, lichBay.getNoiDi());
            stmt.setString(3, lichBay.getNoiDen());
            stmt.setTimestamp(4, Timestamp.valueOf(lichBay.getNgayGioBay()));
            stmt.setInt(5, lichBay.getSoGhe());
            stmt.setBigDecimal(6, lichBay.getGiaVe());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                lichBay.setLichBayID(rs.getInt(1));
            }
        }
    }

    public void update(LichBay lichBay) throws SQLException {
        String sql = "UPDATE LichBay SET MaChuyenBay = ?, NoiDi = ?, NoiDen = ?, NgayGioBay = ?, SoGhe = ?, GiaVe = ? WHERE LichBayID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, lichBay.getMaChuyenBay());
            stmt.setString(2, lichBay.getNoiDi());
            stmt.setString(3, lichBay.getNoiDen());
            stmt.setTimestamp(4, Timestamp.valueOf(lichBay.getNgayGioBay()));
            stmt.setInt(5, lichBay.getSoGhe());
            stmt.setBigDecimal(6, lichBay.getGiaVe());
            stmt.setInt(7, lichBay.getLichBayID());
            stmt.executeUpdate();
        }
    }

    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM LichBay WHERE LichBayID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private LichBay mapRowToLichBay(ResultSet rs) throws SQLException {
        LichBay lichBay = new LichBay();
        lichBay.setLichBayID(rs.getInt("LichBayID"));
        lichBay.setMaChuyenBay(rs.getString("MaChuyenBay"));
        lichBay.setNoiDi(rs.getString("NoiDi"));
        lichBay.setNoiDen(rs.getString("NoiDen"));
        lichBay.setNgayGioBay(rs.getTimestamp("NgayGioBay").toLocalDateTime());
        lichBay.setSoGhe(rs.getInt("SoGhe"));
        lichBay.setGiaVe(rs.getBigDecimal("GiaVe"));
        return lichBay;
    }
}

