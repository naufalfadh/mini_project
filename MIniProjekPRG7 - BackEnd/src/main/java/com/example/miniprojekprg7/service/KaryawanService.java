package com.example.miniprojekprg7.service;

import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.vo.KaryawanVoForm;
import com.example.miniprojekprg7.vo.LoginVo;

public interface KaryawanService {
    DtoResponse getAllKaryawans();
    DtoResponse getKaryawanActive();
    DtoResponse getKaryawanById(int id);

    DtoResponse saveKaryawan(KaryawanVoForm karyawan);

    DtoResponse updateKaryawan(KaryawanVoForm karyawan, int id);

    DtoResponse deleteKaryawan(int id);
    DtoResponse login(LoginVo loginVo);
}
