package com.example.miniprojekprg7.repository;

import com.example.miniprojekprg7.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.example.miniprojekprg7.constant.KaryawanConstant.*;

public interface KaryawanRepository extends JpaRepository<Karyawan, Integer> {
    @Query(value = qAllDataActive, nativeQuery = true)
    List<Karyawan> findByStatus(int status);
    @Procedure(name = "login")
    Karyawan login(@Param("@nama") String nama, @Param("@email") String email);

}
