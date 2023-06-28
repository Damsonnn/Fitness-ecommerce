package com.damcio.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Brand {
    @Id
    @SequenceGenerator(
            name = "brand_id_sequence",
            sequenceName = "brand_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brand_id_sequence"
    )
    private Integer id;
    private String name;
    private String website;
    private String address;
}
