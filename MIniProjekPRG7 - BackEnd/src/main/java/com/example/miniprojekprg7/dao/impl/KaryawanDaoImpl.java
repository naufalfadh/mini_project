package com.example.miniprojekprg7.dao.impl;

import com.example.miniprojekprg7.dao.KaryawanDao;
import com.example.miniprojekprg7.model.Karyawan;
import com.example.miniprojekprg7.repository.KaryawanRepository;
import com.example.miniprojekprg7.vo.KaryawanVo;
import com.example.miniprojekprg7.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KaryawanDaoImpl implements KaryawanDao {
    @Autowired
    private KaryawanRepository karyawanRepository;

    @Override
    public List<KaryawanVo> getKaryawanActive() {
        Iterable<Karyawan> karyawans = karyawanRepository.findByStatus(1);
        List<KaryawanVo> karyawanVos = new ArrayList<>();
        for(Karyawan karyawan : karyawans) {
            KaryawanVo karyawanVo = new KaryawanVo(karyawan);
            karyawanVos.add(karyawanVo);
        }
        return karyawanVos;
    }

    @Override
    public KaryawanVo login(LoginVo loginVo) {
        Karyawan dataLogin = karyawanRepository.login(loginVo.getNama(), loginVo.getEmail());
        KaryawanVo karyawanVo = new KaryawanVo(dataLogin);
        return karyawanVo;
    }
}
