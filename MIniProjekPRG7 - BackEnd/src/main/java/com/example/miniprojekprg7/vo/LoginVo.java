package com.example.miniprojekprg7.vo;

import com.example.miniprojekprg7.model.Karyawan;

public class LoginVo {
    private String nama;
    private String email;
    public LoginVo() {

    }
    public LoginVo(Karyawan karyawan) {
        this.nama = karyawan.getKry_nama();
        this.email = karyawan.getKry_email();
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
}
