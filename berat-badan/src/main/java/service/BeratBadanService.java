package service;

import model.BeratBadan;

import java.util.List;

public interface BeratBadanService {

    // Method untuk mendapatkan semua berat badan
    List<BeratBadan> getAll();

    // Method untuk mendapatkan sebuah berat badan berparameter id berat badan
    BeratBadan getById(Long id);

    // Method untuk menambahkan data berat badan baru
    void add(BeratBadan beratBadan);

    // Mehod ini sengaja dibuat di backend dengan asumsi average akan dibutuhkan juga pada bagian backend
    // Menghitung rata-rata max
    Float averageMax();

    // Menghitung rata-rata min
    Float averageMin();

    // Menghitung rata-rata perbedaan
    Float averagePerbedaan();

}
