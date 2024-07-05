package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.Layanan;

public class LayananVo {
    private Integer id;
    private String nama;
    private String deskripsi;
    private Integer harga;
    private Integer status;


    public LayananVo() {

    }

    public LayananVo(Layanan layanan) {
        this.id = layanan.getIdLayanan();
        this.nama = layanan.getNamaLayanan();
        this.deskripsi = layanan.getDeskripsiLayanan();
        this.harga = layanan.getHargaLayanan();
        this.status = layanan.getStatusLayanan();
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
    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }




    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
