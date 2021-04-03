package com.pegawai.services.impl;

import com.pegawai.entities.Pegawai;
import com.pegawai.entities.PegawaiContact;
import com.pegawai.repositories.PegawaiContactRepository;
import com.pegawai.repositories.PegawaiRepository;
import com.pegawai.services.PegawaiContactService;
import com.pegawai.services.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PegawaiContactServiceImpl implements PegawaiContactService {

    @Autowired
    private PegawaiContactRepository pegawaiContactRepository;

    @Autowired
    private PegawaiService pegawaiService;

    @Autowired
    private PegawaiRepository pegawaiRepository;

    @Override
    public Iterable<PegawaiContact> listPegawaiContacts() throws Exception {
        return pegawaiContactRepository.findAll();
    }

    @Override
    public PegawaiContact getPegawaiContact(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("ID tidak boleh null");
        }
        PegawaiContact pegawaiContact = pegawaiContactRepository.findOne(id);
        if (pegawaiContact == null) {
            throw new Exception("ID tidak ditemukan");
        }
        return pegawaiContact;
    }

    @Override
    public PegawaiContact getPegawaiContactByPegawaiId(Integer pegawaiId) throws Exception {
        if (pegawaiId == null) {
            throw new Exception("ID tidak boleh null");
        }
        PegawaiContact pegawaiContact = pegawaiContactRepository.getByPegawaiId(pegawaiId);
        if (pegawaiContact == null) {
            throw new Exception("ID tidak ditemukan");
        }
        return pegawaiContact;
    }

    @Override
    public PegawaiContact addPegawaiContact(PegawaiContact pegawaiContact) throws Exception {
        Pegawai pegawai = pegawaiRepository.findOne(pegawaiContact.getPegawai().getId());
        if (pegawai == null) {
            throw new Exception("Pegawai dengan ID tersebut tidak ada");
        }
        PegawaiContact pc = pegawaiContactRepository.getByPegawaiId(pegawaiContact.getPegawai().getId());
        if (pc != null) {
            throw new Exception("Pegawai ini sudah memiliki data contact");
        }
        return pegawaiContactRepository.save(pegawaiContact);
    }

}
