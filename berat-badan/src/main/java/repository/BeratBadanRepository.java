package repository;

import model.BeratBadan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Dikarenakan kita hanya perlu crud biasa jadi kita dapat menggunakan CrudRepository untuk memepermudah
@Repository
public interface BeratBadanRepository extends CrudRepository<BeratBadan, Long> {

    @Query(value = "SELECT * FROM berat_badan ORDER BY tanggal DESC")
    List<BeratBadan> findAllOrderByTanggalDesc();

    @Query(value = "SELECT ROUND(AVG(max),1) FROM berat_badan", nativeQuery = true)
    Float averageMax();

    @Query(value = "SELECT ROUND(AVG(min),1) FROM berat_badan", nativeQuery = true)
    Float averageMin();

    @Query(value = "SELECT ROUND(AVG(perbedaan),1) FROM berat_badan", nativeQuery = true)
    Float averagePerbedaan();
}
