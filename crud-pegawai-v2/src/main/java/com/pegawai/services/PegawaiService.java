package com.pegawai.services;

import com.pegawai.entities.Pegawai;

public interface PegawaiService {

    Pegawai getPegawai(Integer id) throws Exception;

    Pegawai addPegawai(Pegawai pegawai) throws Exception;

    Iterable<Pegawai> listPegawai() throws Exception;

}
