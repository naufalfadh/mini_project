package com.example.miniprojekprg7.repository;

import com.example.miniprojekprg7.model.Produsen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.miniprojekprg7.constant.ProdusenConstant.qAllDataActive;

@Repository
public interface ProdusenRepository extends JpaRepository<Produsen, Integer> {
    @Query(value = qAllDataActive, nativeQuery = true)
    List<Produsen> findByStatus(int status);

}