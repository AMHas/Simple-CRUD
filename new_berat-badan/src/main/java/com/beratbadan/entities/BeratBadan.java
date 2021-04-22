package com.beratbadan.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class BeratBadan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tanggal;

    private Integer max;

    private Integer min;

    // Perbedaan bisa saja kita hanya menampilkannya di frontend dengan data max - min,
    // tetapi demi pendataan yang kemungkinan memiliki kegunaan nantinya maka perbedaan dijadikan sebagai attribute
    private Integer perbedaan;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getPerbedaan() {
        return perbedaan;
    }

    public void setPerbedaan(Integer perbedaan) {
        this.perbedaan = perbedaan;
    }
}
