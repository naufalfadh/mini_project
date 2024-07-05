package com.example.miniprojekprg7.service.impl;

import com.example.miniprojekprg7.dao.TrPenjualanDao;
import com.example.miniprojekprg7.model.*;
import com.example.miniprojekprg7.repository.SparepartRepository;
import com.example.miniprojekprg7.repository.DetailPenjualanRepository;
import com.example.miniprojekprg7.repository.KaryawanRepository;
import com.example.miniprojekprg7.repository.TrPenjualanRepository;
import com.example.miniprojekprg7.response.DtoResponse;
import com.example.miniprojekprg7.service.TrPenjualanService;
import com.example.miniprojekprg7.vo.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.miniprojekprg7.constant.TrPenjualanConstant.*;

@Service
@Transactional
public class TrPenjualanServiceImpl implements TrPenjualanService {
    @Autowired
    private TrPenjualanRepository trPenjualanRepository;

    @Autowired
    private TrPenjualanDao trPenjualanDao;

    @Autowired
    private DetailPenjualanRepository detailPenjualanRepository;

    @Autowired
    private SparepartRepository sparepartRepository;

    @Autowired
    private KaryawanRepository karyawanRepository;

    @Override
    public DtoResponse getAllPenjualans() {
        try {
            List<TrPenjualan> trPenjualanList = trPenjualanRepository.findAll();
            List<TpPenjualanVo> tpPenjualanVos = new ArrayList<>();
            for(TrPenjualan penjualan : trPenjualanList) {
                TpPenjualanVo tpPenjualanVo = new TpPenjualanVo(penjualan);
                Karyawan karyawan = karyawanRepository.findById(penjualan.getKry_id()).orElseThrow();
                tpPenjualanVo.setKryNama(karyawan.getKry_nama());
                tpPenjualanVos.add(tpPenjualanVo);
            }

            if (trPenjualanList != null) {
                return new DtoResponse(200, tpPenjualanVos);
            }
            return new DtoResponse(200, null, mEmptyData);
        } catch (Exception e) {
            return  new DtoResponse(500, null, "Internal Server Error");
        }
    }

    @Override
    public DtoResponse savePenjualan(TpPenjualanDetailVoForm tpPenjualanDetailVoForm) {
        try {
            TrPenjualan trPenjualan = new TrPenjualan();
            trPenjualan.setKry_id(tpPenjualanDetailVoForm.getKryId());
            trPenjualan.setTrp_tanggal(tpPenjualanDetailVoForm.getTanggal());
            trPenjualan.setTrp_total(tpPenjualanDetailVoForm.getTotal());

            trPenjualanRepository.save(trPenjualan);

            List<TrPenjualan> allTrPenjualan = trPenjualanRepository.findAll();
            TrPenjualan lastTrPenjualan = allTrPenjualan.get(allTrPenjualan.size() - 1);
            //Save Detail Data
            for(DetailPenjualanVoForm detailPenjualanVo : tpPenjualanDetailVoForm.getDetailPenjualanList()) {
                DetailPenjualanPK detailPenjualanPK = new DetailPenjualanPK();
                detailPenjualanPK.setTrp_id(lastTrPenjualan.getTrp_id());
                detailPenjualanPK.setSparepart_id(detailPenjualanVo.getSparepartId());

                DetailPenjualan detailPenjualan = new DetailPenjualan();
                detailPenjualan.setDetailPenjualanPK(detailPenjualanPK);
                detailPenjualan.setJumlah(detailPenjualanVo.getJumlah());

                detailPenjualanRepository.save(detailPenjualan);
            }
            return new DtoResponse(200, tpPenjualanDetailVoForm, mCreateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, null, mCreateFailed);
        }
    }

    @Override
    public DtoResponse getPenjualanById(int id) {
        try {
            TrPenjualan penjualan =  trPenjualanRepository.findById(id).orElseThrow();
            TpPenjualanDetailVo data = new TpPenjualanDetailVo(penjualan);

            //Get Data Karyawan
            Karyawan karyawan = karyawanRepository.findById(penjualan.getKry_id()).orElseThrow();
            data.setKryNama(karyawan.getKry_nama());

            List<DetailPenjualan> detailPenjualans = detailPenjualanRepository.findAlPenjualanlById(penjualan.getTrp_id());
            for(DetailPenjualan detailPenjualan : detailPenjualans) {
                DetailPenjualanVo dataDetail  = new DetailPenjualanVo(detailPenjualan);
                Sparepart sparepart = sparepartRepository.findById(dataDetail.getSparepartId()).orElseThrow();
                dataDetail.setSparepartNama(sparepart.getSparepart_name());
                dataDetail.setSparepartHarga(sparepart.getSparepart_price());
                data.add(dataDetail);
            }
            return new DtoResponse(200, data);
        } catch (Exception e) {
            return new DtoResponse(404, null, mNotFound);
        }
    }

    @Override
    public DtoResponse getTotalPenjualanPerYear(Integer tahun) {
        try {
            Dashboard dataDashboard = new Dashboard();
            dataDashboard.setDataPenjualanList(trPenjualanDao.getTotalPenjualanPerYear(tahun)); // Memanggil method dari TrPenjualanDao
            dataDashboard.setPenjualanToday(trPenjualanDao.getTotalPenjualanToday());
            dataDashboard.setPenjualanYesterday(trPenjualanDao.getTotalPenjualanYesterday());

            if (dataDashboard != null) {
                return new DtoResponse(200, dataDashboard);
            } else {
                return new DtoResponse(200, null, mEmptyData);
            }
        } catch (Exception e) {
            return new DtoResponse(500, null, e.getMessage());
        }
    }

}
