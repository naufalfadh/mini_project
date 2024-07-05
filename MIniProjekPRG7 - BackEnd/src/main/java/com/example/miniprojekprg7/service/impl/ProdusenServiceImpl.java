package com.example.miniprojekprg7.service.impl;

import com.example.miniprojekprg7.dao.ProdusenDao;
import com.example.miniprojekprg7.model.Produsen;
import com.example.miniprojekprg7.repository.ProdusenRepository;
import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.ProdusenService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.miniprojekprg7.constant.ProdusenConstant.*;

@Service
@Transactional
public class ProdusenServiceImpl implements ProdusenService {
    @Autowired
    private ProdusenDao produsenDao;

    @Autowired
    private ProdusenRepository produsenRepository;

    @Override
    public DtoResponse getAllProdusens() {
        if(produsenDao.getAllProdusens() != null) {
            return new DtoResponse(200, produsenDao.getAllProdusens());
        }
        return new DtoResponse(200, null, mEmptyData);
    }

    @Override
    public DtoResponse getProdusenActive() {
        if(produsenDao.getProdusenActive() != null) {
            return new DtoResponse(200, produsenDao.getProdusenActive());
        }
        return new DtoResponse(200, null, mEmptyData);
    }

    @Override
    public DtoResponse saveProdusen(Produsen produsen) {
        try {
            produsenRepository.save(produsen);
            return new DtoResponse(200, produsen, mCreateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, produsen, mCreateFailed);
        }
    }

    @Override
    public DtoResponse updateProdusen(Produsen newProdusen) {
        try {
            Produsen existingProdusen = produsenRepository.findById(newProdusen.getId_produsen()).orElse(null);

            if (existingProdusen == null) {
                return new DtoResponse(404, null, "Update failed: User not found.");
            }

            if (newProdusen.getNama_produsen() != null) existingProdusen.setNama_produsen(newProdusen.getNama_produsen());
            if (newProdusen.getNegara() != null) existingProdusen.setNegara(newProdusen.getNegara());
            if (newProdusen.getAlamat() != null) existingProdusen.setAlamat(newProdusen.getAlamat());
            if (newProdusen.getTelepon() != null) existingProdusen.setTelepon(newProdusen.getTelepon());
            if (newProdusen.getProfil() != null) existingProdusen.setTelepon(newProdusen.getTelepon());
            if (newProdusen.getStatus() != null) existingProdusen.setStatus(newProdusen.getStatus());

            Produsen updatedProdusen = produsenRepository.save(existingProdusen);

            return new DtoResponse(200, updatedProdusen, "Update successful.");

        } catch (Exception e) {
            return new DtoResponse(500, null, "Update failed: Internal server error.");
        }
    }

    @Override
    public DtoResponse deleteProdusen(Produsen produsen) {
        Produsen produsenData = produsenRepository.findById(produsen.getId_produsen()).orElseThrow();
        if (produsenData != null) {
            try {
                produsenRepository.delete(produsen);
                return new DtoResponse(200, produsen, mDeleteSuccess);
            } catch (Exception e) {
                return new DtoResponse(500, null, mDeleteFailed);
            }
        }
        return new DtoResponse(404, null, mDeleteFailed);
    }
}