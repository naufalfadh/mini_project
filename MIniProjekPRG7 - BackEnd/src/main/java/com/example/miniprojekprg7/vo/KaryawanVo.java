package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.Karyawan;

public class KaryawanVo {
    private Integer id;
    private String nama;
    private String email;
    private String noTlp;
    private Integer status;

    public KaryawanVo() {
    }

    public KaryawanVo(Karyawan karyawan) {
        this.id = karyawan.getKry_id();
        this.nama = karyawan.getKry_nama();
        this.email = karyawan.getKry_email();
        this.noTlp = karyawan.getKry_noTlp();
        this.status = karyawan.getKry_status();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTlp() {
        return noTlp;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
