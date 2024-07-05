package com.example.miniprojekprg7.service.impl;

import com.example.miniprojekprg7.dao.LayananDao;
import com.example.miniprojekprg7.model.Layanan;
import com.example.miniprojekprg7.repository.LayananRepository;
import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.LayananService;
import com.example.miniprojekprg7.vo.LayananVo;
import com.example.miniprojekprg7.vo.LayananVoForm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.miniprojekprg7.constant.LayananConstant.*;

@Service
@Transactional
public class LayananServiceImpl implements LayananService {
    @Autowired
    private LayananDao layananDao;

    @Autowired
    private LayananRepository layananRepository;
    @Override
    public DtoResponse getAllLayanan() {
        try {
            List<Layanan> layanans = layananRepository.findAll();
            if (!layanans.isEmpty()) {
                List<LayananVo> layananVos = new ArrayList<>();
                for (Layanan layanan : layanans) {
                    LayananVo layananVo = new LayananVo();
                    layananVo.setId(layanan.getIdLayanan());
                    layananVo.setNama(layanan.getNamaLayanan());
                    layananVo.setDeskripsi(layanan.getDeskripsiLayanan());
                    layananVo.setHarga(layanan.getHargaLayanan());
                    layananVo.setStatus(layanan.getStatusLayanan());
                    layananVos.add(layananVo);
                }
                return new DtoResponse(200, layananVos);
            }
            return new DtoResponse(200, null, mEmptyData);
        } catch (Exception e) {
            return new DtoResponse(500, null, "Internal Server Error");
        }
    }


    @Override
    public DtoResponse getLayananActive() {
        try {
            if( layananDao.getLayananActive() != null ) {
                return new DtoResponse(200, layananDao.getLayananActive());
            }
            return new DtoResponse(200, null, mEmptyData);
        } catch (Exception e) {
            return new DtoResponse(500, null, "Internal Server Error");
        }
    }

    @Override
    public DtoResponse getLayananById(int id) {
        try {
            if( layananRepository.findById(id).orElseThrow() != null ) {
                return new DtoResponse(200, layananRepository.findById(id).orElseThrow());
            }
            return new DtoResponse(404, null, mNotFound);
        } catch (Exception e) {
            return new DtoResponse(500, null, "Internal Server Error");
        }
    }
    @Override
    public DtoResponse saveLayanan(LayananVoForm layanan) {
        try {
            Layanan newLayanan = new Layanan();
            newLayanan.setNamaLayanan(layanan.getNama());
            newLayanan.setHargaLayanan(layanan.getHarga());
            newLayanan.setDeskripsiLayanan(layanan.getDeskripsi());
            newLayanan.setStatusLayanan(1);
            layananRepository.save(newLayanan);
            return new DtoResponse(200, newLayanan, mCreateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, null, mCreateFailed);
        }
    }


    @Override
    public DtoResponse updateLayanan(LayananVoForm layanan, int id) {
        try {
            if (layananRepository.findById(id) != null) {
                Layanan newLayanan = layananRepository.findById(id).orElseThrow();
                newLayanan.setNamaLayanan(layanan.getNama());
                newLayanan.setHargaLayanan(layanan.getHarga());
                newLayanan.setDeskripsiLayanan(layanan.getDeskripsi());
                newLayanan.setStatusLayanan(1);
                layananRepository.save(newLayanan);
                return new DtoResponse(200, newLayanan, mCreateSuccess);
            }
            return new DtoResponse(404, null, mNotFound);
        } catch (Exception e) {
            return new DtoResponse(500, null, mDeleteFailed);
        }
    }

    @Override
    public DtoResponse deleteLayanan(int id) {
        try {
            if( layananRepository.findById(id) != null ) {
                Layanan layanan = layananRepository.findById(id).orElseThrow();
                layanan.setStatusLayanan(0);
                return new DtoResponse(200, null, mDeleteSuccess);
            }
            return new DtoResponse(404, null, mNotFound);
        } catch (Exception e) {
            return new DtoResponse(500, null, mDeleteFailed);
        }
    }
}
