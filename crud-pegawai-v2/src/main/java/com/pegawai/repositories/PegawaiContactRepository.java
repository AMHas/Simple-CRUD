package com.pegawai.repositories;

import com.pegawai.entities.PegawaiContact;
import org.springframework.data.repository.CrudRepository;

public interface PegawaiContactRepository extends CrudRepository<PegawaiContact, Integer> {

    PegawaiContact getByPegawaiId(Integer pegawaiId);

}
