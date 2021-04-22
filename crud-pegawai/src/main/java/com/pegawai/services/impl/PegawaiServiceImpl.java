package com.pegawai.services.impl;

import com.pegawai.entities.Pegawai;
import com.pegawai.repositories.PegawaiRepository;
import com.pegawai.services.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PegawaiServiceImpl implements PegawaiService {

    @Autowired
    private PegawaiRepository pegawaiRepository;

    @Override
    public Pegawai getPegawai(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("ID tidak boleh null");
        }
        Pegawai pegawai = pegawaiRepository.findOne(id);
        if (pegawai == null) {
            throw new Exception("ID tidak ditemukan");
        }
        return pegawai;
    }

    @Override
    public Pegawai addPegawai(Pegawai pegawai) throws Exception {
        if (pegawai.getNama().isEmpty() || pegawai.getAlamat().isEmpty()) {
            throw new Exception("Nama atau Alamat tidak boleh kosong");
        }
        return pegawaiRepository.save(pegawai);
    }

    @Override
    public Iterable<Pegawai> listPegawai() throws Exception {
        return pegawaiRepository.findAll();
    }
}
