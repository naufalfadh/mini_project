package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.TrPenjualan;

import java.util.Date;

public class TpPenjualanVo {
    private Integer trpId;
    private Date tanggal;
    private Integer total;
    private Integer kryId;
    private String kryNama;

    public TpPenjualanVo() {

    }

    public TpPenjualanVo(TrPenjualan trPenjualan) {
        this.trpId = trPenjualan.getTrp_id();
        this.tanggal = trPenjualan.getTrp_tanggal();
        this.total = trPenjualan.getTrp_total();
        this.kryId = trPenjualan.getKry_id();
    }

    public Integer getTrpId() {
        return trpId;
    }

    public void setTrpId(Integer trpId) {
        this.trpId = trpId;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getKryId() {
        return kryId;
    }

    public void setKryId(Integer kryId) {
        this.kryId = kryId;
    }

    public String getKryNama() {
        return kryNama;
    }

    public void setKryNama(String kryNama) {
        this.kryNama = kryNama;
    }
}
