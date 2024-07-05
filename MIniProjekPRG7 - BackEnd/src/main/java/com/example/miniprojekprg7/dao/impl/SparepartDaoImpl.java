package com.example.miniprojekprg7.dao.impl;

import com.example.miniprojekprg7.dao.SparepartDao;
import com.example.miniprojekprg7.model.Sparepart;
import com.example.miniprojekprg7.repository.SparepartRepository;
import com.example.miniprojekprg7.vo.SparepartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SparepartDaoImpl implements SparepartDao {
    @Autowired
    private SparepartRepository sparepartRepository;

    @Override
    public List<SparepartVo> getSparepartActive() {
        Iterable<Sparepart> spareparts = sparepartRepository.findByStatus(1);
        List<SparepartVo> sparepartVos = new ArrayList<>();
        for(Sparepart sparepart : spareparts) {
            SparepartVo sparepartVo = new SparepartVo(sparepart);
            sparepartVos.add(sparepartVo);
        }
        return sparepartVos;
    }
}
