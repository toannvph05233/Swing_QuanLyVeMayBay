package com.project.dao;

import com.project.models.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {

    // Add new employee to the database
    public void insertNhanVien(NhanVien nhanVien) throws SQLException {
        String query = "INSERT INTO NhanVien (HoTen, SoDienThoai, Email, DiaChi, TaiKhoanID) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nhanVien.getHoTen());
            stmt.setString(2, nhanVien.getSoDienThoai());
            stmt.setString(3, nhanVien.getEmail());
            stmt.setString(4, nhanVien.getDiaChi());
            stmt.setInt(5, nhanVien.getTaiKhoanID());
            stmt.executeUpdate();
        }
    }

    // Retrieve list of all employees
    public List<NhanVien> getAllNhanVien() throws SQLException {
        List<NhanVien> nhanViens = new ArrayList<>();
        String query = "SELECT * FROM NhanVien join taikhoan on NhanVien.taikhoanId = taikhoan.taikhoanId where roleid !=1";
        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(
                        rs.getInt("NhanVienID"),
                        rs.getString("HoTen"),
                        rs.getString("SoDienThoai"),
                        rs.getString("Email"),
                        rs.getString("DiaChi"),
                        rs.getInt("TaiKhoanID")
                );
                nhanViens.add(nhanVien);
            }
        }
        return nhanViens;
    }

    // Update employee information
    public void updateNhanVien(NhanVien nhanVien) throws SQLException {
        String query = "UPDATE NhanVien SET HoTen = ?, SoDienThoai = ?, Email = ?, DiaChi = ? WHERE NhanVienID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nhanVien.getHoTen());
            stmt.setString(2, nhanVien.getSoDienThoai());
            stmt.setString(3, nhanVien.getEmail());
            stmt.setString(4, nhanVien.getDiaChi());
            stmt.setInt(5, nhanVien.getNhanVienId());
            stmt.executeUpdate();
        }
    }

    // Delete employee
    public void deleteNhanVien(int nhanVienId) throws SQLException {
        String query = "DELETE FROM NhanVien WHERE NhanVienID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, nhanVienId);
            stmt.executeUpdate();
        }
    }

    public NhanVien getNhanVienById(int id) throws SQLException {
        String query = "SELECT * FROM NhanVien where NhanVienID=" + id;
        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            rs.next();
            return new NhanVien(
                    rs.getInt("NhanVienID"),
                    rs.getString("HoTen"),
                    rs.getString("SoDienThoai"),
                    rs.getString("Email"),
                    rs.getString("DiaChi"),
                    rs.getInt("TaiKhoanID")
            );

        }catch(Exception ex){
            return null;
        }
    }

}
