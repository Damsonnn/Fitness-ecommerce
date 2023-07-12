package com.damcio.shop.service;

import com.damcio.shop.model.CartProduct;
import java.util.List;

public interface CartProductService {

    CartProduct createCartProduct(CartProduct cartProduct);

    CartProduct getCartProductById(Integer id);

    List<CartProduct> getAllCartProducts();

    CartProduct updateCartProduct(CartProduct cartProduct);

    void deleteCartProduct(Integer id);
}
