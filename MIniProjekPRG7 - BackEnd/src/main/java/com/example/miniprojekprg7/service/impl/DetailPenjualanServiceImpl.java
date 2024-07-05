package com.example.miniprojekprg7.service.impl;

import com.example.miniprojekprg7.constant.DetailPenjualanConstant;
import com.example.miniprojekprg7.dao.DetailPenjualanDao;
import com.example.miniprojekprg7.model.DetailPenjualan;
import com.example.miniprojekprg7.model.DetailPenjualanPK;
import com.example.miniprojekprg7.repository.SparepartRepository;
import com.example.miniprojekprg7.repository.DetailPenjualanRepository;
import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.DetailPenjualanService;
import com.example.miniprojekprg7.vo.DetailPenjualanVoForm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DetailPenjualanServiceImpl implements DetailPenjualanService {
    @Autowired
    private DetailPenjualanDao detailPenjualanDao;
    @Autowired
    private DetailPenjualanRepository detailPenjualanRepository;
    @Autowired
    private SparepartRepository sparepartRepository;
    @Override
    public DtoResponse getAllDetailPenjualans(){
        if (detailPenjualanDao.getAllDetailPenjualans() != null){
            return new DtoResponse(200, detailPenjualanDao.getAllDetailPenjualans());
        }
        return new DtoResponse(200, null, DetailPenjualanConstant.mEmptyData);
    }
    @Override
    public DtoResponse saveDetailPenjualan(DetailPenjualanVoForm dpv){
        try{
            DetailPenjualan dp = new DetailPenjualan();
            dp.setJumlah(dpv.getJumlah());
            DetailPenjualanPK dpk = new DetailPenjualanPK();
            dpk.setSparepart_id(dpv.getSparepartId());
            dp.setDetailPenjualanPK(dpk);
            detailPenjualanRepository.save(dp);
            return new DtoResponse(200, dp, DetailPenjualanConstant.mCreateSuccess);
        }catch (Exception e){
            return new DtoResponse(500, dpv, DetailPenjualanConstant.mCreateFailed);
        }
    }
}
