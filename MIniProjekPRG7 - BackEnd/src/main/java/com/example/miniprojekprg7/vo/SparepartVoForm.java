package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.Sparepart;

public class SparepartVoForm {
    private String nama;
    private Integer harga;
    private Integer stok;
    private String sup;
    private Integer status;
    private Integer creaby;
    private Integer modiby;

    public SparepartVoForm() {

    }

    public SparepartVoForm(Sparepart sparepart) {
        this.nama = sparepart.getSparepart_name();
        this.harga = sparepart.getSparepart_price();
        this.stok = sparepart.getSparepart_stock();
        this.sup = sparepart.getSparepart_brand();
        this.status = sparepart.getSparepart_status();
        this.creaby = sparepart.getCreated_by();
        this.modiby = sparepart.getModified_by();
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

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getSup() {
        return sup;
    }

    public void setSup(String sup) {
        this.sup = sup;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreaby() {
        return creaby;
    }

    public void setCreaby(Integer creaby) {
        this.creaby = creaby;
    }

    public Integer getModiby() {
        return modiby;
    }

    public void setModiby(Integer modiby) {
        this.modiby = modiby;
    }
}
