package com.example.miniprojekprg7.repository;

import com.example.miniprojekprg7.model.Layanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static com.example.miniprojekprg7.constant.LayananConstant.qAllDataActive;

public interface LayananRepository extends JpaRepository<Layanan, Integer> {
    @Query(value = qAllDataActive, nativeQuery = true)
    List<Layanan> findByStatus(int status);
}
