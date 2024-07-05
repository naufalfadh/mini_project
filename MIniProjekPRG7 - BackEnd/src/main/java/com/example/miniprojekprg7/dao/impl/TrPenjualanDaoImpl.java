package com.example.miniprojekprg7.dao.impl;

import com.example.miniprojekprg7.dao.TrPenjualanDao;
import com.example.miniprojekprg7.model.DataPenjualan;
import com.example.miniprojekprg7.repository.TrPenjualanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrPenjualanDaoImpl implements TrPenjualanDao {
    @Autowired
    private TrPenjualanRepository trPenjualanRepository;

    @Override
    public List<DataPenjualan> getTotalPenjualanPerYear(Integer tahun) {
        List<DataPenjualan> dataPenjualanList = new ArrayList<>();

        // Memanggil prosedur yang telah didefinisikan di repository
        List<Object[]> resultList = trPenjualanRepository.getTotalPenjualanPerYear(tahun);
        System.out.println("Resullist : " + resultList);
        // Memproses hasil dan memasukkannya ke dalam list DataPenjualan
        for (Object[] result : resultList) {
            Integer bulan = (Integer) result[0];
            Integer total = (Integer)  result[1];
            DataPenjualan dataPenjualan = new DataPenjualan(bulan, total);
            dataPenjualanList.add(dataPenjualan);
        }

        return dataPenjualanList;
    }

    @Override
    public Integer getTotalPenjualanToday() {
        Integer total = trPenjualanRepository.getTotalPenjualanToday();
        return total;
    }

    @Override
    public Integer getTotalPenjualanYesterday() {
        Integer total = trPenjualanRepository.getTotalPenjualanYesterday();
        return total;
    }
}
