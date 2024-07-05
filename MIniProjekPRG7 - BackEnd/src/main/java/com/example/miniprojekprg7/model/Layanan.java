package com.example.miniprojekprg7.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "msLayanan")
public class Layanan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLayanan")
    private Integer IdLayanan;

    @Column(name = "NamaLayanan")
    private String NamaLayanan;

    @Column(name = "DeskripsiLayanan")
    private String DeskripsiLayanan;

    @Column(name = "HargaLayanan")
    private Integer HargaLayanan;
    @Column(name = "StatusLayanan")
    private Integer StatusLayanan;


    public Layanan() {
    }

    public Layanan(Integer idLayanan, String namaLayanan, String deskripsiLayanan, Integer hargaLayanan, Integer statusLayanan) {
        IdLayanan = idLayanan;
        NamaLayanan = namaLayanan;
        DeskripsiLayanan = deskripsiLayanan;
        HargaLayanan = hargaLayanan;
        StatusLayanan = statusLayanan;
    }

    public Integer getIdLayanan() {
        return IdLayanan;
    }

    public void setIdLayanan(Integer idLayanan) {
        IdLayanan = idLayanan;
    }

    public String getNamaLayanan() {
        return NamaLayanan;
    }

    public void setNamaLayanan(String namaLayanan) {
        NamaLayanan = namaLayanan;
    }

    public String getDeskripsiLayanan() {
        return DeskripsiLayanan;
    }

    public void setDeskripsiLayanan(String deskripsiLayanan) {
        DeskripsiLayanan = deskripsiLayanan;
    }

    public Integer getHargaLayanan() {
        return HargaLayanan;
    }

    public void setHargaLayanan(Integer hargaLayanan) {
        HargaLayanan = hargaLayanan;
    }

    public Integer getStatusLayanan() {
        return StatusLayanan;
    }

    public void setStatusLayanan(Integer statusLayanan) {
        StatusLayanan = statusLayanan;
    }


}
