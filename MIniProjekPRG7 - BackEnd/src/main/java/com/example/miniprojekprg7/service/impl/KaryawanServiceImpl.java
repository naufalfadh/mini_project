package com.example.miniprojekprg7.service.impl;

import com.example.miniprojekprg7.dao.KaryawanDao;
import com.example.miniprojekprg7.model.Karyawan;
import com.example.miniprojekprg7.repository.KaryawanRepository;
import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.KaryawanService;
import com.example.miniprojekprg7.vo.KaryawanVo;
import com.example.miniprojekprg7.vo.KaryawanVoForm;
import com.example.miniprojekprg7.vo.LoginVo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.miniprojekprg7.constant.KaryawanConstant.*;

@Service
@Transactional
public class KaryawanServiceImpl implements KaryawanService {
    @Autowired
    private KaryawanDao karyawanDao;

    @Autowired
    private KaryawanRepository karyawanRepository;

    @Override
    public DtoResponse getAllKaryawans() {
        try {
            if (karyawanRepository.findAll() != null) {
                Iterable<Karyawan> karyawans = karyawanRepository.findAll();
                List<KaryawanVo> karyawanVoList = new ArrayList<>();
                for (Karyawan karyawan : karyawans ) {
                    KaryawanVo karyawanVo =  new KaryawanVo();
                    karyawanVo.setId(karyawan.getKry_id());
                    karyawanVo.setNama(karyawan.getKry_nama());
                    karyawanVo.setEmail(karyawan.getKry_email());
                    karyawanVo.setNoTlp(karyawan.getKry_noTlp());
                    karyawanVo.setStatus(karyawan.getKry_status());
                    karyawanVoList.add(karyawanVo);
                }
                return new DtoResponse(200, karyawanVoList);
            }
            return new DtoResponse(200, null, mEmptyData);
        } catch (Exception e) {
            return new DtoResponse(500, null, "Internal Server Error");
        }
    }

    @Override
    public DtoResponse getKaryawanActive() {
        try {
            if( karyawanDao.getKaryawanActive() != null ) {
                return new DtoResponse(200, karyawanDao.getKaryawanActive());
            }
            return new DtoResponse(200, null, mEmptyData);
        } catch (Exception e) {
            return new DtoResponse(500, null, "Internal Server Error");
        }
    }

    @Override
    public DtoResponse getKaryawanById(int id) {
        try {
            if( karyawanRepository.findById(id).orElseThrow() != null ) {
                KaryawanVo karyawanVo = new KaryawanVo();
                Karyawan karyawan = karyawanRepository.findById(id).orElseThrow();
                karyawanVo.setId(karyawan.getKry_id());
                karyawanVo.setNama(karyawan.getKry_nama());
                karyawanVo.setEmail(karyawan.getKry_email());
                karyawanVo.setNoTlp(karyawan.getKry_noTlp());
                karyawanVo.setStatus(karyawan.getKry_status());
                
                return new DtoResponse(200, karyawanVo);
            }
            return new DtoResponse(404, null, mNotFound);
        } catch (Exception e) {
            return new DtoResponse(500, null, "Internal Server Error");
        }
    }

    @Override
    public DtoResponse saveKaryawan(KaryawanVoForm karyawan) {
        try {
            Karyawan karyawanCreate = new Karyawan();
            karyawanCreate.setKry_nama(karyawan.getNama());
            karyawanCreate.setKry_email(karyawan.getEmail());
            karyawanCreate.setKry_noTlp(karyawan.getNoTlp());
            karyawanCreate.setKry_status(1);
            karyawanCreate.setKry_creaby(karyawan.getCreaby());
            karyawanCreate.setKry_creadate(new Date());
            karyawanRepository.save(karyawanCreate);
            return new DtoResponse(200, karyawan, mCreateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, null, mCreateFailed);
        }
    }

    @Override
    public DtoResponse updateKaryawan(KaryawanVoForm karyawan, int id) {
        try {
            if( karyawanRepository.findById(id) != null ) {
                Karyawan existedData = karyawanRepository.findById(id).orElseThrow();
                Karyawan dataUpdate = new Karyawan();
                dataUpdate.setKry_id(karyawan.getId() == null ? existedData.getKry_id() : karyawan.getId());
                dataUpdate.setKry_nama(karyawan.getNama() == null ? existedData.getKry_nama() : karyawan.getNama());
                dataUpdate.setKry_email(karyawan.getEmail() == null ? existedData.getKry_email() : karyawan.getEmail());
                dataUpdate.setKry_noTlp(karyawan.getNoTlp() == null ? existedData.getKry_noTlp() : karyawan.getNoTlp());
                dataUpdate.setKry_status(karyawan.getStatus() == null ? existedData.getKry_status() : karyawan.getStatus());
                dataUpdate.setKry_creadate(existedData.getKry_creadate());
                dataUpdate.setKry_creaby(existedData.getKry_creaby());
                dataUpdate.setKry_modiby(karyawan.getModiby());
                dataUpdate.setKry_modidate(new Date());
                karyawanRepository.save(dataUpdate);
                return new DtoResponse(200, dataUpdate, mUpdateSuccess);
            }
            return new DtoResponse(404, null, mNotFound);
        } catch (Exception e) {
            return new DtoResponse(500, null, mUpdateFailed);
        }
    }

    @Override
    public DtoResponse deleteKaryawan(int id) {
        try {
            if( karyawanRepository.findById(id) != null ) {
                Karyawan karyawan = karyawanRepository.findById(id).orElseThrow();
                karyawan.setKry_status(0);
                return new DtoResponse(200, null, mDeleteSuccess);
            }
            return new DtoResponse(404, null, mNotFound);
        } catch (Exception e) {
            return new DtoResponse(500, null, mDeleteFailed);
        }
    }

    @Override
    public DtoResponse login(LoginVo loginVo) {
        try {
            if( karyawanDao.login(loginVo) != null ) {
                return new DtoResponse(200, karyawanDao.login(loginVo));
            }
            return new DtoResponse(200, null, mEmptyData);
        } catch (Exception e) {
            return new DtoResponse(500, null, e.getMessage());
        }
    }
}
