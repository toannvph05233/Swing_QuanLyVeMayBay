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
public class LichBay {
    private Integer lichBayID;
    private String maChuyenBay;
    private String noiDi;
    private String noiDen;
    private LocalDateTime ngayGioBay;
    private Integer soGhe;
    private BigDecimal giaVe;

    public LichBay(Integer lichBayID, String maChuyenBay, String noiDi, String noiDen, LocalDateTime ngayGioBay, Integer soGhe, BigDecimal giaVe) {
        this.lichBayID = lichBayID;
        this.maChuyenBay = maChuyenBay;
        this.noiDi = noiDi;
        this.noiDen = noiDen;
        this.ngayGioBay = ngayGioBay;
        this.soGhe = soGhe;
        this.giaVe = giaVe;
    }

    public LichBay() {
    }
    
   

    public Integer getLichBayID() {
        return lichBayID;
    }

    public void setLichBayID(Integer lichBayID) {
        this.lichBayID = lichBayID;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getNoiDi() {
        return noiDi;
    }

    public void setNoiDi(String noiDi) {
        this.noiDi = noiDi;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public LocalDateTime getNgayGioBay() {
        return ngayGioBay;
    }

    public void setNgayGioBay(LocalDateTime ngayGioBay) {
        this.ngayGioBay = ngayGioBay;
    }

    public Integer getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(Integer soGhe) {
        this.soGhe = soGhe;
    }

    public BigDecimal getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(BigDecimal giaVe) {
        this.giaVe = giaVe;
    }
    
    

}
