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
import com.project.models.VeMayBay;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class VeMayBayDAO {

    // 1. Lấy tất cả vé máy bay
    public List<VeMayBay> getAllVeMayBay() {
        List<VeMayBay> veList = new ArrayList<>();
        String sql = "SELECT * FROM VeMayBay";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            
            while (rs.next()) {
                VeMayBay ve = new VeMayBay();
                ve.setVeID(rs.getInt("VeID"));
                ve.setKhachHangID(rs.getInt("KhachHangID"));
                ve.setLichBayID(rs.getInt("LichBayID"));
                ve.setGiaVe(rs.getBigDecimal("GiaVe"));
                ve.setNgayDatVe(rs.getTimestamp("NgayDatVe").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                ve.setTrangThai(rs.getString("TrangThai"));
                veList.add(ve);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return veList;
    }
    
    public List<VeMayBay> getAllVeMayBayByIdKhach(int idKhach) {
        List<VeMayBay> veList = new ArrayList<>();
        String sql = "SELECT * FROM VeMayBay where khachhangid = " + idKhach;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            
            while (rs.next()) {
                VeMayBay ve = new VeMayBay();
                ve.setVeID(rs.getInt("VeID"));
                ve.setKhachHangID(rs.getInt("KhachHangID"));
                ve.setLichBayID(rs.getInt("LichBayID"));
                ve.setGiaVe(rs.getBigDecimal("GiaVe"));
                ve.setNgayDatVe(rs.getTimestamp("NgayDatVe").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                ve.setTrangThai(rs.getString("TrangThai"));
                veList.add(ve);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return veList;
    }

    // 2. Tìm kiếm vé máy bay theo ID
    public VeMayBay findVeById(int veID) {
        VeMayBay ve = null;
        String sql = "SELECT * FROM VeMayBay WHERE VeID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, veID);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    ve = new VeMayBay();
                    ve.setVeID(rs.getInt("VeID"));
                    ve.setKhachHangID(rs.getInt("KhachHangID"));
                    ve.setLichBayID(rs.getInt("LichBayID"));
                    ve.setGiaVe(rs.getBigDecimal("GiaVe"));
                    ve.setNgayDatVe(rs.getTimestamp("NgayDatVe").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                    ve.setTrangThai(rs.getString("TrangThai"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ve;
    }

    // 3. Thêm mới vé máy bay
    public boolean insertVe(VeMayBay ve) {
        String sql = "INSERT INTO VeMayBay (KhachHangID, LichBayID, GiaVe, NgayDatVe, TrangThai) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, ve.getKhachHangID());
            statement.setInt(2, ve.getLichBayID());
            statement.setBigDecimal(3, ve.getGiaVe());
            statement.setTimestamp(4, Timestamp.valueOf(ve.getNgayDatVe()));
            statement.setString(5, ve.getTrangThai());
            
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    // 4. Cập nhật vé máy bay
    public boolean updateVe(VeMayBay ve) {
        String sql = "UPDATE VeMayBay SET KhachHangID = ?, LichBayID = ?, GiaVe = ?, NgayDatVe = ?, TrangThai = ? WHERE VeID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, ve.getKhachHangID());
            statement.setInt(2, ve.getLichBayID());
            statement.setBigDecimal(3, ve.getGiaVe());
            statement.setTimestamp(4, Timestamp.valueOf(ve.getNgayDatVe()));
            statement.setString(5, ve.getTrangThai());
            statement.setInt(6, ve.getVeID());
            
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    // 5. Xóa vé máy bay
    public boolean deleteVe(int veID) {
        String sql = "DELETE FROM VeMayBay WHERE VeID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, veID);
            
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteVeByKhach(int khachID) {
        String sql = "DELETE FROM VeMayBay WHERE KhachHangID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, khachID);
            
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
     public boolean deleteVeByLichBay(int lichBayID) {
        String sql = "DELETE FROM VeMayBay WHERE lichBayID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, lichBayID);
            
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}

