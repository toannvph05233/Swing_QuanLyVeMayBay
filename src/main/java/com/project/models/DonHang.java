/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.models;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author johntoan98gmail.com
 */
public class DonHang {
     private Integer donHangID;
    private Integer khachHangID;
    private Integer nhanVienID;
    private LocalDateTime ngayTao;
    private BigDecimal tongTien;

    public Integer getDonHangID() {
        return donHangID;
    }

    public void setDonHangID(Integer donHangID) {
        this.donHangID = donHangID;
    }

    public Integer getKhachHangID() {
        return khachHangID;
    }

    public void setKhachHangID(Integer khachHangID) {
        this.khachHangID = khachHangID;
    }

    public Integer getNhanVienID() {
        return nhanVienID;
    }

    public void setNhanVienID(Integer nhanVienID) {
        this.nhanVienID = nhanVienID;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
