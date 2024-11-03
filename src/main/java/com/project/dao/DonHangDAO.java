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
import com.project.models.DonHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DonHangDAO {

    // 1. Lấy tất cả đơn hàng
    public List<DonHang> getAllDonHang() {
        List<DonHang> donHangList = new ArrayList<>();
        String sql = "SELECT * FROM DonHang";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            
            while (rs.next()) {
                DonHang donHang = new DonHang();
                donHang.setDonHangID(rs.getInt("DonHangID"));
                donHang.setKhachHangID(rs.getInt("KhachHangID"));
                donHang.setNhanVienID(rs.getInt("NhanVienID"));
                donHang.setNgayTao(rs.getTimestamp("NgayTao").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                donHang.setTongTien(rs.getBigDecimal("TongTien"));
                donHangList.add(donHang);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return donHangList;
    }

    // 2. Tìm kiếm đơn hàng theo ID
    public DonHang findDonHangById(int donHangID) {
        DonHang donHang = null;
        String sql = "SELECT * FROM DonHang WHERE DonHangID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, donHangID);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    donHang = new DonHang();
                    donHang.setDonHangID(rs.getInt("DonHangID"));
                    donHang.setKhachHangID(rs.getInt("KhachHangID"));
                    donHang.setNhanVienID(rs.getInt("NhanVienID"));
                    donHang.setNgayTao(rs.getTimestamp("NgayTao").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                    donHang.setTongTien(rs.getBigDecimal("TongTien"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return donHang;
    }

    // 3. Thêm mới đơn hàng
    public boolean insertDonHang(DonHang donHang) {
        String sql = "INSERT INTO DonHang (KhachHangID, NhanVienID, NgayTao, TongTien) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, donHang.getKhachHangID());
            statement.setInt(2, donHang.getNhanVienID());
            statement.setTimestamp(3, Timestamp.valueOf(donHang.getNgayTao()));
            statement.setBigDecimal(4, donHang.getTongTien());
            
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    // 4. Cập nhật đơn hàng
    public boolean updateDonHang(DonHang donHang) {
        String sql = "UPDATE DonHang SET KhachHangID = ?, NhanVienID = ?, NgayTao = ?, TongTien = ? WHERE DonHangID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, donHang.getKhachHangID());
            statement.setInt(2, donHang.getNhanVienID());
            statement.setTimestamp(3, Timestamp.valueOf(donHang.getNgayTao()));
            statement.setBigDecimal(4, donHang.getTongTien());
            statement.setInt(5, donHang.getDonHangID());
            
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    // 5. Xóa đơn hàng
    public boolean deleteDonHang(int donHangID) {
        String sql = "DELETE FROM DonHang WHERE DonHangID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, donHangID);
            
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
     public boolean deleteDonHangByKhachHangID(int khachHangID) {
        String sql = "DELETE FROM DonHang WHERE KhachHangID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, khachHangID);
            
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
     
      public boolean deleteDonHangByNhanVienID(int NhanVienID) {
        String sql = "DELETE FROM DonHang WHERE NhanVienID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, NhanVienID);
            
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}

