package com.example.miniprojekprg7.service;

import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.vo.DetailPenjualanVoForm;

public interface DetailPenjualanService {
    DtoResponse getAllDetailPenjualans();
    DtoResponse saveDetailPenjualan(DetailPenjualanVoForm dpv);
}
