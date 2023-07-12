package com.damcio.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Cart {
    @Id
    @SequenceGenerator(
        name = "cart_id_sequence",
        sequenceName = "cart_id_sequence",
        allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_id_sequence"
    )
    private Integer id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartProduct> cartProducts;

    private Double finalPrice;

    public void setFinalPrice() {
        this.finalPrice = cartProducts.stream().mapToDouble(CartProduct::getPriceOfProducts).sum();
    }
}
