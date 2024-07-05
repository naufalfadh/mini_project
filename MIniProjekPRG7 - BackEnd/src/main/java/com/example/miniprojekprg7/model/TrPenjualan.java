package com.example.miniprojekprg7.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sparepart_trpenjualan")
public class TrPenjualan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trp_id")
    private Integer trp_id;
    @Column(name = "trp_tanggal")
    private Date trp_tanggal;
    @Column(name = "trp_total")
    private Integer trp_total;
    @Column(name = "kry_id")
    private Integer kry_id;

    public TrPenjualan() {
    }

    public TrPenjualan(Integer trp_id, Date trp_tanggal, Integer trp_total, Integer kry_id) {
        this.trp_id = trp_id;
        this.trp_tanggal = trp_tanggal;
        this.trp_total = trp_total;
        this.kry_id = kry_id;
    }

    public Integer getTrp_id() {
        return trp_id;
    }

    public void setTrp_id(Integer trp_id) {
        this.trp_id = trp_id;
    }

    public Date getTrp_tanggal() {
        return trp_tanggal;
    }

    public void setTrp_tanggal(Date trp_tanggal) {
        this.trp_tanggal = trp_tanggal;
    }

    public Integer getTrp_total() {
        return trp_total;
    }

    public void setTrp_total(Integer trp_total) {
        this.trp_total = trp_total;
    }

    public Integer getKry_id() {
        return kry_id;
    }

    public void setKry_id(Integer kry_id) {
        this.kry_id = kry_id;
    }
}
