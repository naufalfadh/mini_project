package com.example.miniprojekprg7.model;

public class DataPenjualan {
    private Integer Bulan;
    private Integer Total;

    public DataPenjualan() {

    }

    public DataPenjualan(Integer bulan, Integer total) {
        Bulan = bulan;
        Total = total;
    }

    public Integer getBulan() {
        return Bulan;
    }

    public void setBulan(Integer bulan) {
        Bulan = bulan;
    }

    public Integer getTotal() {
        return Total;
    }

    public void setTotal(Integer total) {
        Total = total;
    }
}
