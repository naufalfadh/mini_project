package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.DetailPenjualan;

public class DetailPenjualanVoForm {
    private Integer sparepartId;
    private Integer jumlah;

    public DetailPenjualanVoForm() {
    }

    public DetailPenjualanVoForm(DetailPenjualan detailPenjualan) {
        this.sparepartId = detailPenjualan.getDetailPenjualanPK().getSparepart_id();
        this.jumlah = detailPenjualan.getJumlah();
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
