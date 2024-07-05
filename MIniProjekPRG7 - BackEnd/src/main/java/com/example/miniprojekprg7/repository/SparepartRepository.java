package com.example.miniprojekprg7.repository;

import com.example.miniprojekprg7.model.Sparepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static com.example.miniprojekprg7.constant.SparepartConstant.*;

public interface SparepartRepository extends JpaRepository<Sparepart, Integer> {
    @Query(value = qAllDataActive, nativeQuery = true)
    List<Sparepart> findByStatus(int status);
}
