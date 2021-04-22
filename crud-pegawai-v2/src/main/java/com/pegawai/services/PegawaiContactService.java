package com.pegawai.services;

import com.pegawai.entities.Pegawai;
import com.pegawai.entities.PegawaiContact;

public interface PegawaiContactService {

    Iterable<PegawaiContact> listPegawaiContacts() throws Exception;

    PegawaiContact getPegawaiContact(Integer id) throws Exception;

    PegawaiContact getPegawaiContactByPegawaiId(Integer pegawaiId) throws Exception;

    PegawaiContact addPegawaiContact(PegawaiContact pegawaiContact) throws Exception;

}
