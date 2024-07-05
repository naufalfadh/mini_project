package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.Produsen;

import java.math.BigDecimal;

public class ProdusenVo {
    private Integer id;
    private String nama;
    private String negara;
    private String alamat;
    private String telepon;
    private String profil;
    private Integer status;

    public ProdusenVo(){
    }

    public ProdusenVo(Produsen produsen) {
        this.id = produsen.getId_produsen();
        this.nama = produsen.getNama_produsen();
        this.negara = produsen.getNegara();
        this.alamat = produsen.getAlamat();
        this.telepon = produsen.getTelepon();
        this.profil = produsen.getAlamat();
        this.status = produsen.getStatus();
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

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
