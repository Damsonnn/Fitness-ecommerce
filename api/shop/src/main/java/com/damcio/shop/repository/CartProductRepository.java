package com.damcio.shop.repository;

import com.damcio.shop.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository  extends JpaRepository<CartProduct, Integer> {
}
