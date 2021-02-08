package com.beratbadan.services.impl;

import com.beratbadan.entities.BeratBadan;
import com.beratbadan.repositories.BeratBadanRepository;
import com.beratbadan.services.BeratBadanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeratBadanServiceImpl implements BeratBadanService {

    private BeratBadanRepository beratBadanRepository;

    @Autowired
    public void setBeratBadanRepository(BeratBadanRepository beratBadanRepository) {
        this.beratBadanRepository = beratBadanRepository;
    }

    @Override
    public Iterable<BeratBadan> listAllBeratBadan() {
        return beratBadanRepository.getAllOrderByTanggalDesc();
    }

    @Override
    public BeratBadan getBeratBadanById(Integer id) {
        return beratBadanRepository.findOne(id);
    }

    @Override
    public BeratBadan saveBeratBadan(BeratBadan beratBadan) {
        // Kalkulasikan perbedaan sebelum menyimpan
        Integer perbedaan = beratBadan.getMax() - beratBadan.getMin();
        beratBadan.setPerbedaan(perbedaan);
        return beratBadanRepository.save(beratBadan);
    }

    @Override
    public Float averageMax() {
        return beratBadanRepository.averageMax();
    }

    @Override
    public Float averageMin() {
        return beratBadanRepository.averageMin();
    }

    @Override
    public Float averagePerbedaan() {
        return beratBadanRepository.averagePerbedaan();
    }

}
