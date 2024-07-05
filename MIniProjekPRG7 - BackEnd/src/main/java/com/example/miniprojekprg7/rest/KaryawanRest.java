package com.example.miniprojekprg7.rest;

import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.KaryawanService;
import com.example.miniprojekprg7.vo.KaryawanVoForm;
import com.example.miniprojekprg7.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/karyawans")
public class KaryawanRest {
    @Autowired
    private KaryawanService karyawanService;

    public KaryawanRest(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }

    @GetMapping("/getKaryawans")
    public DtoResponse getAtks() {
        return karyawanService.getAllKaryawans();
    }

    @GetMapping("/getKaryawanById/{id}")
    public DtoResponse getKaryawanById(@PathVariable int id) {
        return karyawanService.getKaryawanById(id);
    }

    @GetMapping("/getKaryawanActive")
    public DtoResponse getKaryawanActive() {
        return karyawanService.getKaryawanActive();
    }
    @PostMapping("/login")
    public DtoResponse Login(@RequestBody LoginVo loginVo) {
        return karyawanService.login(loginVo);
    }

    @PostMapping("/saveKaryawan")
    public DtoResponse saveKaryawan(@RequestBody KaryawanVoForm karyawan) {
        return karyawanService.saveKaryawan(karyawan);
    }

    @PostMapping("/updateKaryawan/{id}")
    public DtoResponse updateKaryawan(@RequestBody KaryawanVoForm karyawan, @PathVariable int id) {
        return karyawanService.updateKaryawan(karyawan, id);
    }

    @PostMapping("/deleteKaryawan/{id}")
    public DtoResponse deleteKaryawan( @PathVariable int id) {
        return karyawanService.deleteKaryawan(id);
    }
}
