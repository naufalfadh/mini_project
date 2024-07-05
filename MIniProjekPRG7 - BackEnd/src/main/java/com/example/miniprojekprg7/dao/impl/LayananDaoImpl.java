package com.example.miniprojekprg7.dao.impl;

import com.example.miniprojekprg7.dao.LayananDao;
import com.example.miniprojekprg7.model.Layanan;
import com.example.miniprojekprg7.repository.LayananRepository;
import com.example.miniprojekprg7.vo.LayananVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LayananDaoImpl implements LayananDao {
    @Autowired
    private LayananRepository layananRepository;

    @Override
    public List<LayananVo> getLayananActive() {
        Iterable<Layanan> layanans = layananRepository.findByStatus(1);
        List<LayananVo> layananVos = new ArrayList<>();
        for(Layanan layanan : layanans) {
            LayananVo layananVo = new LayananVo(layanan);
            layananVos.add(layananVo);
        }
        return layananVos;
    }
}
