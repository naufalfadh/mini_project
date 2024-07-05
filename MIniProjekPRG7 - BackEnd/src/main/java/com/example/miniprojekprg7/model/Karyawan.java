package com.example.miniprojekprg7.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "atk_mskaryawan")
public class Karyawan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kry_id")
    private Integer kry_id;
    @Column(name = "kry_nama")
    private String kry_nama;
    @Column(name = "kry_email")
    private String kry_email;
    @Column(name = "kry_no_tlp")
    private String kry_noTlp;
    @Column(name = "kry_status")
    private Integer kry_status;
    @Column(name = "kry_creaby")
    private Integer kry_creaby;
    @Column(name = "kry_creadate")
    private Date kry_creadate;
    @Column(name = "kry_modiby")
    private Integer kry_modiby;
    @Column(name = "kry_modidate")
    private Date kry_modidate;

    public Karyawan() {

    }

    public Karyawan(Integer kry_id, String kry_nama, String kry_email, String kry_noTlp, Integer kry_status, Integer kry_creaby, Date kry_creadate, Integer kry_modiby, Date kry_modidate) {
        this.kry_id = kry_id;
        this.kry_nama = kry_nama;
        this.kry_email = kry_email;
        this.kry_noTlp = kry_noTlp;
        this.kry_status = kry_status;
        this.kry_creaby = kry_creaby;
        this.kry_creadate = kry_creadate;
        this.kry_modiby = kry_modiby;
        this.kry_modidate = kry_modidate;
    }

    public Integer getKry_id() {

        return kry_id;
    }

    public void setKry_id(Integer kry_id) {
        this.kry_id = kry_id;
    }

    public String getKry_nama() {
        return kry_nama;
    }

    public void setKry_nama(String kry_nama) {
        this.kry_nama = kry_nama;
    }

    public String getKry_email() {
        return kry_email;
    }

    public void setKry_email(String kry_email) {
        this.kry_email = kry_email;
    }

    public String getKry_noTlp() {
        return kry_noTlp;
    }

    public void setKry_noTlp(String kry_noTlp) {
        this.kry_noTlp = kry_noTlp;
    }

    public Integer getKry_status() {
        return kry_status;
    }

    public void setKry_status(Integer kry_status) {
        this.kry_status = kry_status;
    }

    public Integer getKry_creaby() {
        return kry_creaby;
    }

    public void setKry_creaby(Integer kry_creaby) {
        this.kry_creaby = kry_creaby;
    }

    public Date getKry_creadate() {
        return kry_creadate;
    }

    public void setKry_creadate(Date kry_creadate) {
        this.kry_creadate = kry_creadate;
    }

    public Date getKry_modidate() {
        return kry_modidate;
    }

    public void setKry_modidate(Date kry_modidate) {
        this.kry_modidate = kry_modidate;
    }

    public Integer getKry_modiby() {
        return kry_modiby;
    }

    public void setKry_modiby(Integer kry_modiby) {
        this.kry_modiby = kry_modiby;
    }
}
