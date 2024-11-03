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
public class VeMayBay {
    private Integer veID;
    private Integer khachHangID;
    private Integer lichBayID;
    private BigDecimal giaVe;
    private LocalDateTime ngayDatVe;
    private String trangThai;

    public Integer getVeID() {
        return veID;
    }

    public void setVeID(Integer veID) {
        this.veID = veID;
    }

    public Integer getKhachHangID() {
        return khachHangID;
    }

    public void setKhachHangID(Integer khachHangID) {
        this.khachHangID = khachHangID;
    }

    public Integer getLichBayID() {
        return lichBayID;
    }

    public void setLichBayID(Integer lichBayID) {
        this.lichBayID = lichBayID;
    }

    public BigDecimal getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(BigDecimal giaVe) {
        this.giaVe = giaVe;
    }

    public LocalDateTime getNgayDatVe() {
        return ngayDatVe;
    }

    public void setNgayDatVe(LocalDateTime ngayDatVe) {
        this.ngayDatVe = ngayDatVe;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
