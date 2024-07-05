package com.example.miniprojekprg7.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "sparepart_dtlpenjualan")
public class DetailPenjualan implements Serializable {
    @EmbeddedId
    private DetailPenjualanPK detailPenjualanPK;

    @Column(name = "jumlah")
    private Integer jumlah;

    public DetailPenjualan() {
    }

    public DetailPenjualan(DetailPenjualanPK detailPenjualanPK, Integer jumlah) {
        this.detailPenjualanPK = detailPenjualanPK;
        this.jumlah = jumlah;
    }

    public DetailPenjualanPK getDetailPenjualanPK() {
        return detailPenjualanPK;
    }

    public void setDetailPenjualanPK(DetailPenjualanPK detailPenjualanPK) {
        this.detailPenjualanPK = detailPenjualanPK;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}
