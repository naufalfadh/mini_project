package com.example.miniprojekprg7.dao.impl;

import com.example.miniprojekprg7.dao.DetailPenjualanDao;
import com.example.miniprojekprg7.model.DetailPenjualan;
import com.example.miniprojekprg7.repository.SparepartRepository;
import com.example.miniprojekprg7.repository.DetailPenjualanRepository;
import com.example.miniprojekprg7.vo.DetailPenjualanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DetailPenjualanDaoImpl implements DetailPenjualanDao {
    @Autowired
    private DetailPenjualanRepository detailPenjualanRepository;
    @Autowired
    private SparepartRepository sparepartRepository;
    @Override
    public List<DetailPenjualanVo> getAllDetailPenjualans(){
        Iterable<DetailPenjualan> detailPenjualans = detailPenjualanRepository.findAll();
        List<DetailPenjualanVo> detailPenjualanVos = new ArrayList<>();
        for(DetailPenjualan item: detailPenjualans){
            DetailPenjualanVo detailPenjualanVo = new DetailPenjualanVo(item);

            detailPenjualanVos.add(detailPenjualanVo);
        }
        return detailPenjualanVos;
    }
}
