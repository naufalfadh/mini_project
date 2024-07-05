package com.example.miniprojekprg7.dao.impl;

import com.example.miniprojekprg7.dao.ProdusenDao;
import com.example.miniprojekprg7.model.Produsen;
import com.example.miniprojekprg7.repository.ProdusenRepository;
import com.example.miniprojekprg7.vo.ProdusenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdusenDaoImpl implements ProdusenDao {
    @Autowired
    private ProdusenRepository produsenRepository;

    @Override
    public List<ProdusenVo> getAllProdusens(){
        Iterable<Produsen> produsens = produsenRepository.findAll();
        List<ProdusenVo> produsenVos = new ArrayList<>();
        for (Produsen item: produsens){
            ProdusenVo produsenVo = new ProdusenVo(item);
            produsenVos.add(produsenVo);
        }
        return produsenVos;
    }

    @Override
    public List<ProdusenVo> getProdusenActive(){
        Iterable<Produsen> produsens = produsenRepository.findByStatus(1);
        List<ProdusenVo> produsenVos = new ArrayList<>();
        for (Produsen item: produsens){
            ProdusenVo produsenVo = new ProdusenVo(item);
            produsenVos.add(produsenVo);
        }
        return produsenVos;
    }
}
