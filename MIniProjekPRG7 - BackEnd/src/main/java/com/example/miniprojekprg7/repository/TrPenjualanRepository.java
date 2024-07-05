package com.example.miniprojekprg7.repository;

import com.example.miniprojekprg7.model.TrPenjualan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.example.miniprojekprg7.constant.TrPenjualanConstant.*;

public interface TrPenjualanRepository extends JpaRepository<TrPenjualan, Integer> {
    @Procedure(name = "GetTotalPenjualanPerYear")
    List<Object[]> getTotalPenjualanPerYear(@Param("inputYear") Integer inputYear);

    @Query(value = getTotalPenjualanToday, nativeQuery = true)
    Integer getTotalPenjualanToday();

    @Query(value = getTotalPenjualanYesterday, nativeQuery = true)
    Integer getTotalPenjualanYesterday();
}
