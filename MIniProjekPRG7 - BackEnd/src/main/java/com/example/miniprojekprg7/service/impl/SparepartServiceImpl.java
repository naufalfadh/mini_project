package com.example.miniprojekprg7.service.impl;

import com.example.miniprojekprg7.dao.SparepartDao;
import com.example.miniprojekprg7.model.Sparepart;
import com.example.miniprojekprg7.repository.SparepartRepository;
import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.SparepartService;
import com.example.miniprojekprg7.vo.SparepartVo;
import com.example.miniprojekprg7.vo.SparepartVoForm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.miniprojekprg7.constant.SparepartConstant.*;
@Service
@Transactional
public class SparepartServiceImpl implements SparepartService {
    @Autowired
    private SparepartDao sparepartDao;

    @Autowired
    private SparepartRepository sparepartRepository;
    @Override
    public DtoResponse getAllSpareparts() {
        try {
            List<Sparepart> spareparts = sparepartRepository.findAll();
            if (!spareparts.isEmpty()) {
                List<SparepartVo> sparepartVos = new ArrayList<>();
                for (Sparepart sparepart : spareparts) {
                    SparepartVo sparepartVo = new SparepartVo();
                    sparepartVo.setId(sparepart.getSparepart_id());
                    sparepartVo.setNama(sparepart.getSparepart_name());
                    sparepartVo.setStok(sparepart.getSparepart_stock());
                    sparepartVo.setSup(sparepart.getSparepart_brand());
                    sparepartVo.setHarga(sparepart.getSparepart_price());
                    sparepartVo.setStatus(sparepart.getSparepart_status());
                    sparepartVos.add(sparepartVo);
                }
                return new DtoResponse(200, sparepartVos);
            }
            return new DtoResponse(200, null, mEmptyData);
        } catch (Exception e) {
            return new DtoResponse(500, null, "Internal Server Error");
        }
    }


    @Override
    public DtoResponse getSparepartActive() {
        try {
            if( sparepartDao.getSparepartActive() != null ) {
                return new DtoResponse(200, sparepartDao.getSparepartActive());
            }
            return new DtoResponse(200, null, mEmptyData);
        } catch (Exception e) {
            return new DtoResponse(500, null, "Internal Server Error");
        }
    }

    @Override
    public DtoResponse getSparepartById(int id) {
        try {
            if( sparepartRepository.findById(id).orElseThrow() != null ) {
                return new DtoResponse(200, sparepartRepository.findById(id).orElseThrow());
            }
            return new DtoResponse(404, null, mNotFound);
        } catch (Exception e) {
            return new DtoResponse(500, null, "Internal Server Error");
        }
    }
    @Override
    public DtoResponse saveSparepart(SparepartVoForm sparepart) {
        try {
            Sparepart newSparepart = new Sparepart();
            newSparepart.setSparepart_name(sparepart.getNama());
            newSparepart.setSparepart_price(sparepart.getHarga());
            newSparepart.setSparepart_stock(sparepart.getStok());
            newSparepart.setSparepart_brand(sparepart.getSup());
            newSparepart.setSparepart_status(1);
            newSparepart.setCreated_by(sparepart.getCreaby());
            newSparepart.setCreation_date(new Date());
            sparepartRepository.save(newSparepart);
            return new DtoResponse(200, newSparepart, mCreateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, null, mCreateFailed);
        }
    }


    @Override
    public DtoResponse updateSparepart(SparepartVoForm sparepart, int id) {
        try {
            if (sparepartRepository.findById(id) != null) {
                Sparepart newSparepart = sparepartRepository.findById(id).orElseThrow();
                newSparepart.setSparepart_name(sparepart.getNama());
                newSparepart.setSparepart_price(sparepart.getHarga());
                newSparepart.setSparepart_stock(sparepart.getStok());
                newSparepart.setSparepart_brand(sparepart.getSup());
                newSparepart.setSparepart_status(1);
                newSparepart.setCreated_by(sparepart.getCreaby());
                newSparepart.setCreation_date(new Date());
                sparepartRepository.save(newSparepart);
                return new DtoResponse(200, newSparepart, mCreateSuccess);
            }
            return new DtoResponse(404, null, mNotFound);
        } catch (Exception e) {
            return new DtoResponse(500, null, mDeleteFailed);
        }
    }

    @Override
    public DtoResponse deleteSparepart(int id) {
        try {
            if( sparepartRepository.findById(id) != null ) {
                Sparepart sparepart = sparepartRepository.findById(id).orElseThrow();
                sparepart.setSparepart_status(0);
                return new DtoResponse(200, null, mDeleteSuccess);
            }
            return new DtoResponse(404, null, mNotFound);
        } catch (Exception e) {
            return new DtoResponse(500, null, mDeleteFailed);
        }
    }
}
