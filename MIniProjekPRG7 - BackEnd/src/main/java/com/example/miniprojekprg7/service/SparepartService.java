package com.example.miniprojekprg7.service;

import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.vo.SparepartVoForm;

public interface SparepartService {
    DtoResponse getAllSpareparts();
    DtoResponse getSparepartActive();
    DtoResponse getSparepartById(int id);

    DtoResponse saveSparepart(SparepartVoForm sparepart);

    DtoResponse updateSparepart(SparepartVoForm sparepart, int id);

    DtoResponse deleteSparepart(int id);
}
