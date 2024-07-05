package com.example.miniprojekprg7.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_produsen")
public class Produsen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produsen")
    private Integer id_produsen;
    @Column(name = "nama_produsen")
    private String nama_produsen;
    @Column(name = "negara")
    private String negara;
    @Column(name = "alamat")
    private String alamat   ;
    @Column(name = "telepon")
    private String telepon;
    @Column(name = "profil")
    private String  profil;
    @Column(name = "status")
    private Integer status;

    public Produsen(Integer id_produsen, String nama_produsen, String negara, String alamat, String telepon, String profil, Integer status) {
        this.id_produsen = id_produsen;
        this.nama_produsen = nama_produsen;
        this.negara = negara;
        this.alamat = alamat;
        this.telepon = telepon;
        this.profil = profil;
        this.status = status;
    }


    public Produsen() {

    }

    public Integer getId_produsen() {
        return id_produsen;
    }

    public void setId_produsen(Integer id_produsen) {
        this.id_produsen = id_produsen;
    }

    public String getNama_produsen() {
        return nama_produsen;
    }

    public void setNama_produsen(String nama_produsen) {
        this.nama_produsen = nama_produsen;
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

    public void setProfil(String  profil) {
        this.profil = profil;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
