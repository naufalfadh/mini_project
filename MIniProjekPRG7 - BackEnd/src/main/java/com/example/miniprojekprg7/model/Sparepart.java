package com.example.miniprojekprg7.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_sparepart")
public class Sparepart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sparepart_id")
    private Integer sparepart_id;

    @Column(name = "sparepart_name")
    private String sparepart_name;

    @Column(name = "sparepart_price")
    private Integer sparepart_price;

    @Column(name = "sparepart_stock")
    private Integer sparepart_stock;

    @Column(name = "sparepart_brand")
    private String sparepart_brand;

    @Column(name = "sparepart_status")
    private Integer sparepart_status;

    @Column(name = "created_by")
    private Integer created_by;

    @Column(name = "creation_date")
    private Date creation_date;

    @Column(name = "modified_by")
    private Integer modified_by;

    @Column(name = "modification_date")
    private Date modification_date;

    public Sparepart() {
    }

    public Sparepart(Integer sparepart_id, String sparepart_name, Integer sparepart_price, Integer sparepart_stock, String sparepart_brand, Integer sparepart_status, Integer created_by, Date creation_date, Integer modified_by, Date modification_date) {
        this.sparepart_id = sparepart_id;
        this.sparepart_name = sparepart_name;
        this.sparepart_price = sparepart_price;
        this.sparepart_stock = sparepart_stock;
        this.sparepart_brand = sparepart_brand;
        this.sparepart_status = sparepart_status;
        this.created_by = created_by;
        this.creation_date = creation_date;
        this.modified_by = modified_by;
        this.modification_date = modification_date;
    }

    // Getters and setters
    public Integer getSparepart_id() {
        return sparepart_id;
    }

    public void setSparepart_id(Integer sparepart_id) {
        this.sparepart_id = sparepart_id;
    }

    public String getSparepart_name() {
        return sparepart_name;
    }

    public void setSparepart_name(String sparepart_name) {
        this.sparepart_name = sparepart_name;
    }

    public Integer getSparepart_price() {
        return sparepart_price;
    }

    public void setSparepart_price(Integer sparepart_price) {
        this.sparepart_price = sparepart_price;
    }

    public Integer getSparepart_stock() {
        return sparepart_stock;
    }

    public void setSparepart_stock(Integer sparepart_stock) {
        this.sparepart_stock = sparepart_stock;
    }

    public String getSparepart_brand() {
        return sparepart_brand;
    }

    public void setSparepart_brand(String sparepart_brand) {
        this.sparepart_brand = sparepart_brand;
    }

    public Integer getSparepart_status() {
        return sparepart_status;
    }

    public void setSparepart_status(Integer sparepart_status) {
        this.sparepart_status = sparepart_status;
    }

    public Integer getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Integer created_by) {
        this.created_by = created_by;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Integer getModified_by() {
        return modified_by;
    }

    public void setModified_by(Integer modified_by) {
        this.modified_by = modified_by;
    }

    public Date getModification_date() {
        return modification_date;
    }

    public void setModification_date(Date modification_date) {
        this.modification_date = modification_date;
    }
}
