package com.example.miniprojekprg7.dao;

import com.example.miniprojekprg7.vo.KaryawanVo;
import com.example.miniprojekprg7.vo.LoginVo;

import java.util.List;

public interface KaryawanDao {
    List<KaryawanVo> getKaryawanActive();
    KaryawanVo login(LoginVo loginVo);
}
