package com.damcio.shop.service;

import com.damcio.shop.model.Cart;
import com.damcio.shop.model.Category;

import java.util.List;

public interface CartService {

    Cart createCart(Cart cart);

    Cart getCartById(Integer id);

    List<Cart> getAllCarts();

    Cart updateCart(Cart cart);

    void deleteCart(Integer id);
}
