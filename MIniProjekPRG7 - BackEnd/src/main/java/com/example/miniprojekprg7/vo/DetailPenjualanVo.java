package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.DetailPenjualan;

public class DetailPenjualanVo {
    private Integer sparepartId;
    private String sparepartNama;
    private Integer sparepartHarga;
    private Integer jumlah;

    public DetailPenjualanVo() {
    }

    public DetailPenjualanVo(DetailPenjualan detailPenjualan) {
        this.sparepartId = detailPenjualan.getDetailPenjualanPK().getSparepart_id();
        this.jumlah = detailPenjualan.getJumlah();
    }

    public String getSparepartNama() {
        return sparepartNama;
    }

    public void setSparepartNama(String sparepartNama) {
        this.sparepartNama = sparepartNama;
    }

    public Integer getSparepartHarga() {
        return sparepartHarga;
    }

    public void setSparepartHarga(Integer sparepartHarga) {
        this.sparepartHarga = sparepartHarga;
    }

    public Integer getSparepartId() {
        return sparepartId;
    }

    public void setSparepartId(Integer sparepartId) {
        this.sparepartId = sparepartId;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}
