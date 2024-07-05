package com.example.miniprojekprg7.rest;

import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.LayananService;
import com.example.miniprojekprg7.vo.LayananVoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/layanans")
public class LayananRest {
    private final LayananService layananService;

    @Autowired
    public LayananRest(LayananService layananService) {
        this.layananService = layananService;
    }

    @GetMapping("/getAllLayanan")
    public DtoResponse getAllLayanan() {
        return layananService.getAllLayanan();
    }

    @GetMapping("/getLayananById/{id}")
    public DtoResponse getLayananById(@PathVariable int id) {
        return layananService.getLayananById(id);
    }

    @GetMapping("/getSpareparsActive")
    public DtoResponse getSpareparsActive() {
        return layananService.getLayananActive();
    }

    @PostMapping("/saveLayanan")
    public DtoResponse saveLayanan(@RequestBody LayananVoForm layanan) {
        return layananService.saveLayanan(layanan);
    }

    @PostMapping("/updateLayanan/{id}")
    public DtoResponse updateLayanan(@RequestBody LayananVoForm layanan, @PathVariable int id) {
        return layananService.updateLayanan(layanan, id);
    }

    @PostMapping("/deleteLayanan/{id}")
    public DtoResponse deleteLayanan(@PathVariable int id) {
        return layananService.deleteLayanan(id);
    }
}
