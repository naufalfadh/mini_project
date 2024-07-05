package com.example.miniprojekprg7.rest;

import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.DetailPenjualanService;
import com.example.miniprojekprg7.vo.DetailPenjualanVoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detailPenjualan")
public class DetailPenjualanRest {
    @Autowired
    private DetailPenjualanService detailPenjualanService;
    public DetailPenjualanRest(DetailPenjualanService detailPenjualanService){
        this.detailPenjualanService = detailPenjualanService;
    }
    @GetMapping("/getDetailPenjualans")
    public DtoResponse getDetailPenjualans() {return detailPenjualanService.getAllDetailPenjualans();}
    @GetMapping("/getDetailPenjualanActive")
    @PostMapping("/saveDetailPenjualan")
    public DtoResponse createDetailPenjualan(@RequestBody DetailPenjualanVoForm detailPenjualanVoForm){
        return detailPenjualanService.saveDetailPenjualan(detailPenjualanVoForm);
    }
}
