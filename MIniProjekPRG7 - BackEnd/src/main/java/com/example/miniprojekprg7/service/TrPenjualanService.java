package com.example.miniprojekprg7.service;

import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.vo.TpPenjualanDetailVoForm;

public interface TrPenjualanService {
    DtoResponse getAllPenjualans();
    DtoResponse savePenjualan(TpPenjualanDetailVoForm tpPenjualanDetailVoForm);
    DtoResponse getPenjualanById(int id);
    DtoResponse getTotalPenjualanPerYear(Integer tahun);

}
