package service.impl;

import model.BeratBadan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BeratBadanRepository;
import service.BeratBadanService;

import javax.transaction.Transactional;
import java.util.List;

// Implementasi dari interfece berat badan
@Service
@Transactional
public class BeratBadanServiceImpl implements BeratBadanService {

    @Autowired
    private BeratBadanRepository beratBadanRepository;

    @Override
    public List<BeratBadan> getAll() {
        return beratBadanRepository.findAllOrderByTanggalDesc();
    }

    @Override
    public BeratBadan getById(Long id) {
        return beratBadanRepository.findById(id).get();
    }

    @Override
    public void add(BeratBadan beratBadan) {
        // Kalkulasikan perbedaan sebelum menyimpan
        Long perbedaan = beratBadan.getMax() - beratBadan.getMin();
        beratBadan.setPerbedaan(perbedaan);
        beratBadanRepository.save(beratBadan);
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
