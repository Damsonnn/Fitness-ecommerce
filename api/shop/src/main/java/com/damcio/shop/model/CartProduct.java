package com.damcio.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class CartProduct {
    @Id
    @SequenceGenerator(
            name = "order_product_id_sequence",
            sequenceName = "order_product_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_product_sequence"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private Double priceOfProducts;

    public void setPriceOfProducts() {
        this.priceOfProducts = getQuantity() * getProduct().getPrice();
    }
}
