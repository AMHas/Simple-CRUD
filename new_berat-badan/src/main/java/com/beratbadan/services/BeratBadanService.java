package com.beratbadan.services;

import com.beratbadan.entities.BeratBadan;

public interface BeratBadanService {

    // Method untuk mendapatkan semua berat badan
    Iterable<BeratBadan> listAllBeratBadan();

    // Method untuk mendapatkan sebuah berat badan berparameter id berat badan
    BeratBadan getBeratBadanById(Integer id);

    // Method untuk menambahkan data berat badan baru
    BeratBadan saveBeratBadan(BeratBadan beratBadan);

    // Mehod ini sengaja dibuat di backend dengan asumsi average akan dibutuhkan juga pada bagian backend
    // Menghitung rata-rata max
    Float averageMax();

    // Menghitung rata-rata min
    Float averageMin();

    // Menghitung rata-rata perbedaan
    Float averagePerbedaan();

}
