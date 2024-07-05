package com.example.miniprojekprg7.rest;

import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.TrPenjualanService;
import com.example.miniprojekprg7.vo.TpPenjualanDetailVoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/penjualans")
public class TrPenjualanRest {
    @Autowired
    private TrPenjualanService trPenjualanService;

    public TrPenjualanRest(TrPenjualanService trPenjualanService) {
        this.trPenjualanService = trPenjualanService;
    }

    @GetMapping("/getPenjualans")
    public DtoResponse getPenjuals() {
        return trPenjualanService.getAllPenjualans();
    }

    @GetMapping("/getPenjualanById/{id}")
    public DtoResponse getPenjualanById(@PathVariable int id) {
        return trPenjualanService.getPenjualanById(id);
    }


    @PostMapping("/savePenjualan")
    public DtoResponse savePenjualan(@RequestBody TpPenjualanDetailVoForm tpPenjualanDetailVoForm) {
        return trPenjualanService.savePenjualan(tpPenjualanDetailVoForm);
    }

    @GetMapping("/Dashboard/{tahun}")
    public DtoResponse getTotalPenjualanPerYear(@PathVariable Integer tahun) {
        return trPenjualanService.getTotalPenjualanPerYear(tahun);
    }
}
