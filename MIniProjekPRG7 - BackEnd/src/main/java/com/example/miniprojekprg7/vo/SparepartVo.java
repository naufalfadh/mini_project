package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.Sparepart;

public class SparepartVo {
    private Integer id;
    private String nama;
    private Integer harga;
    private Integer stok;
    private String sup;
    private Integer status;


    public SparepartVo() {

    }

    public SparepartVo(Sparepart sparepart) {
        this.id = sparepart.getSparepart_id();
        this.nama = sparepart.getSparepart_name();
        this.harga = sparepart.getSparepart_price();
        this.stok = sparepart.getSparepart_stock();
        this.sup = sparepart.getSparepart_brand();
        this.status = sparepart.getSparepart_status();
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
}
