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
public class ThongKe {
     private Integer thongKeID;
    private LocalDateTime ngayThang;
    private BigDecimal tongDoanhThu;
    private Integer soVeBan;
    private Integer soDonHang;

    public Integer getThongKeID() {
        return thongKeID;
    }

    public void setThongKeID(Integer thongKeID) {
        this.thongKeID = thongKeID;
    }

    public LocalDateTime getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(LocalDateTime ngayThang) {
        this.ngayThang = ngayThang;
    }

    public BigDecimal getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(BigDecimal tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    public Integer getSoVeBan() {
        return soVeBan;
    }

    public void setSoVeBan(Integer soVeBan) {
        this.soVeBan = soVeBan;
    }

    public Integer getSoDonHang() {
        return soDonHang;
    }

    public void setSoDonHang(Integer soDonHang) {
        this.soDonHang = soDonHang;
    }
    
    
}
