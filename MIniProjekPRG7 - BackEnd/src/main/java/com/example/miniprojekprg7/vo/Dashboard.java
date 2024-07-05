package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.DataPenjualan;

import java.util.List;

public class Dashboard {
    private Integer penjualanToday;
    private Integer penjualanYesterday;
    private List<DataPenjualan> dataPenjualanList;

    public Dashboard() {

    }

    public Integer getPenjualanToday() {
        return penjualanToday;
    }

    public void setPenjualanToday(Integer penjualanToday) {
        this.penjualanToday = penjualanToday;
    }

    public Integer getPenjualanYesterday() {
        return penjualanYesterday;
    }

    public void setPenjualanYesterday(Integer penjualanYesterday) {
        this.penjualanYesterday = penjualanYesterday;
    }

    public List<DataPenjualan> getDataPenjualanList() {
        return dataPenjualanList;
    }

    public void setDataPenjualanList(List<DataPenjualan> dataPenjualanList) {
        this.dataPenjualanList = dataPenjualanList;
    }
}
