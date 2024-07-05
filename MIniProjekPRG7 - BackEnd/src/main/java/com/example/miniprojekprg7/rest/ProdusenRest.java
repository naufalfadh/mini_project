package com.example.miniprojekprg7.rest;

import com.example.miniprojekprg7.model.Produsen;
import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.ProdusenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/produsens")
public class ProdusenRest {
    @Autowired
    private ProdusenService produsenService;
    public ProdusenRest(ProdusenService produsenService) {
        this.produsenService = produsenService;
    }

    @GetMapping("/getProdusens")
    public DtoResponse getProdusens() {
        return produsenService.getAllProdusens();
    }

    @GetMapping("/getProdusenActive")
    public DtoResponse getProdusenActive() {
        return produsenService.getProdusenActive();
    }

    @PostMapping("/saveProdusen")
    public DtoResponse saveProdusen(@RequestBody Produsen produsen) {
        return produsenService.saveProdusen(produsen);
    }

    @PostMapping("/updateProdusen")
    public DtoResponse updateProdusen(@RequestBody Produsen produsen) {
        return produsenService.updateProdusen(produsen);
    }

    @PostMapping("/deleteProdusen")
    public DtoResponse deleteProdusen( @RequestBody Produsen produsen) {
        return produsenService.deleteProdusen(produsen);
    }
}