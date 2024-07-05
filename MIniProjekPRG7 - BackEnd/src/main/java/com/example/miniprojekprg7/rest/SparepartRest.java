package com.example.miniprojekprg7.rest;

import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.SparepartService;
import com.example.miniprojekprg7.vo.SparepartVoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/spareparts")
public class SparepartRest {
    private final SparepartService sparepartService;

    @Autowired
    public SparepartRest(SparepartService sparepartService) {
        this.sparepartService = sparepartService;
    }

    @GetMapping("/getAllSpareparts")
    public DtoResponse getAllSpareparts() {
        return sparepartService.getAllSpareparts();
    }

    @GetMapping("/getSparepartById/{id}")
    public DtoResponse getSparepartById(@PathVariable int id) {
        return sparepartService.getSparepartById(id);
    }

    @GetMapping("/getSpareparsActive")
    public DtoResponse getSpareparsActive() {
        return sparepartService.getSparepartActive();
    }

    @PostMapping("/saveSparepart")
    public DtoResponse saveSparepart(@RequestBody SparepartVoForm sparepart) {
        return sparepartService.saveSparepart(sparepart);
    }

    @PostMapping("/updateSparepart/{id}")
    public DtoResponse updateSparepart(@RequestBody SparepartVoForm sparepart, @PathVariable int id) {
        return sparepartService.updateSparepart(sparepart, id);
    }

    @PostMapping("/deleteSparepart/{id}")
    public DtoResponse deleteSparepart(@PathVariable int id) {
        return sparepartService.deleteSparepart(id);
    }
}
