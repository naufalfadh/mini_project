package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.Layanan;

public class LayananVoForm {
    private String nama;
    private Integer harga;
    private String deskripsi;
    private Integer status;

    public LayananVoForm() {

    }

    public LayananVoForm(Layanan layanan) {
        this.nama = layanan.getNamaLayanan();
        this.harga = layanan.getHargaLayanan();
        this.deskripsi = layanan.getDeskripsiLayanan();
        this.status = layanan.getStatusLayanan();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }



    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
