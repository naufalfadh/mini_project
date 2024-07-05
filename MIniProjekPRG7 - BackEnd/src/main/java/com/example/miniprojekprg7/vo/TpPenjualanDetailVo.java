package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.TrPenjualan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TpPenjualanDetailVo {
    private Integer trpId;
    private Date tanggal;
    private Integer total;
    private Integer kryId;
    private String kryNama;

    private List<DetailPenjualanVo> detailPenjualanList = new ArrayList<>();

    public TpPenjualanDetailVo(TrPenjualan trPenjualan) {
        this.trpId = trPenjualan.getTrp_id();
        this.tanggal = trPenjualan.getTrp_tanggal();
        this.total = trPenjualan.getTrp_total();
        this.kryId = trPenjualan.getKry_id();
    }

    public String getKryNama() {
        return kryNama;
    }

    public void setKryNama(String kryNama) {
        this.kryNama = kryNama;
    }

    public void  add(DetailPenjualanVo detailPenjualanVo) {
        detailPenjualanList.add(detailPenjualanVo);
    }

    public List<DetailPenjualanVo> getDetailPenjualanList() {
        return detailPenjualanList;
    }

    public void setDetailPenjualanList(List<DetailPenjualanVo> detailPenjualanList) {
        this.detailPenjualanList = detailPenjualanList;
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
}
