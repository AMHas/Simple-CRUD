package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

// Model berat badan, hibernate ddl-auto = update
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "berat_badan")
public class BeratBadan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tanggal")
    private Date tanggal;

    @Column(name = "max")
    private Long max;

    @Column(name = "min")
    private Long min;

    // Perbedaan bisa saja kita hanya menampilkannya di frontend dengan data max - min,
    // tetapi demi pendataan yang kemungkinan memiliki kegunaan nantinya maka perbedaan dijadikan sebagai attribute
    @Column(name = "perbedaan")
    private Long perbedaan;

}
