package com.example.miniprojekprg7.service;

import com.example.miniprojekprg7.model.Produsen;
import com.example.miniprojekprg7.response.DtoResponse;

public interface ProdusenService {
    DtoResponse getAllProdusens();
    DtoResponse getProdusenActive();

    DtoResponse saveProdusen(Produsen produsen);

    DtoResponse updateProdusen(Produsen produsen);

    DtoResponse deleteProdusen(Produsen produsen);
}
