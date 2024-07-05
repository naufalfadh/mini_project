package com.example.miniprojekprg7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DetailPenjualanPK implements Serializable {
    @Column(name = "trp_id")
    private Integer trp_id;
    @Column(name = "sparepart_id")
    private Integer sparepart_id;
    public DetailPenjualanPK(){}

    public DetailPenjualanPK(Integer trp_id, Integer sparepart_id, Integer jumlah) {
        this.trp_id = trp_id;
        this.sparepart_id = sparepart_id;
    }

    public Integer getTrp_id() {
        return trp_id;
    }

    public void setTrp_id(Integer trp_id) {
        this.trp_id = trp_id;
    }

    public Integer getSparepart_id() {
        return sparepart_id;
    }

    public void setSparepart_id(Integer sparepart_id) {
        this.sparepart_id = sparepart_id;
    }
}
