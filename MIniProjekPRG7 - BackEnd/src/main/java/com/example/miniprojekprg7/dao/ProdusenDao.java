package com.example.miniprojekprg7.dao;

import com.example.miniprojekprg7.vo.ProdusenVo;

import java.util.List;

public interface ProdusenDao {
    List<ProdusenVo> getAllProdusens();
    List<ProdusenVo> getProdusenActive();
}
