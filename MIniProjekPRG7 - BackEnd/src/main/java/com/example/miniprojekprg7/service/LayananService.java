package com.example.miniprojekprg7.service;

import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.vo.LayananVoForm;

public interface LayananService {
    DtoResponse getAllLayanan();
    DtoResponse getLayananActive();
    DtoResponse getLayananById(int id);

    DtoResponse saveLayanan(LayananVoForm layanan);

    DtoResponse updateLayanan(LayananVoForm layanan, int id);

    DtoResponse deleteLayanan(int id);
}
