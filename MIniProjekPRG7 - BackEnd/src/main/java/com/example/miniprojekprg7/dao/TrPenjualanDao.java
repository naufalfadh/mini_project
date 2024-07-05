package com.example.miniprojekprg7.dao;

import com.example.miniprojekprg7.model.DataPenjualan;

import java.util.List;

public interface TrPenjualanDao {
    List<DataPenjualan> getTotalPenjualanPerYear(Integer tahun);

    Integer getTotalPenjualanToday();
    Integer getTotalPenjualanYesterday();
}
