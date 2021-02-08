package com.beratbadan.repositories;

import com.beratbadan.entities.BeratBadan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.xml.ws.RequestWrapper;

public interface BeratBadanRepository extends CrudRepository<BeratBadan, Integer> {

    @Query(value = "SELECT * FROM berat_badan ORDER BY tanggal DESC", nativeQuery = true)
    Iterable<BeratBadan> getAllOrderByTanggalDesc();

    @Query(value = "SELECT ROUND(AVG(max),1) FROM berat_badan", nativeQuery = true)
    Float averageMax();

    @Query(value = "SELECT ROUND(AVG(min),1) FROM berat_badan", nativeQuery = true)
    Float averageMin();

    @Query(value = "SELECT ROUND(AVG(perbedaan),1) FROM berat_badan", nativeQuery = true)
    Float averagePerbedaan();

}
