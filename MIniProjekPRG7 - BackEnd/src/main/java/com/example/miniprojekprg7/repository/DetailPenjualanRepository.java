package com.example.miniprojekprg7.repository;

import com.example.miniprojekprg7.constant.DetailPenjualanConstant;
import com.example.miniprojekprg7.model.DetailPenjualan;
import com.example.miniprojekprg7.model.DetailPenjualanPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetailPenjualanRepository extends JpaRepository<DetailPenjualan, DetailPenjualanPK> {
    @Query(value = DetailPenjualanConstant.qAllDataActive, nativeQuery = true)
    List<DetailPenjualan> findAllDataActive();
    @Query(value = DetailPenjualanConstant.getDataById, nativeQuery = true)
    List<DetailPenjualan> findAlPenjualanlById(@Param("id") Integer trpId);
}
