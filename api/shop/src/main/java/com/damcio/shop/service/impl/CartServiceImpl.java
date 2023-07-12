package com.damcio.shop.service.impl;

import com.damcio.shop.model.Cart;
import com.damcio.shop.model.Category;
import com.damcio.shop.repository.CartRepository;
import com.damcio.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart createCart(Cart cart) {
        cart.setFinalPrice();
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Integer id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        return optionalCart.get();
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart updateCart(Cart cart) {
        Cart existingCart = cartRepository.findById(cart.getId()).get();
        existingCart.setCartProducts(cart.getCartProducts());
        existingCart.setFinalPrice();
        Cart updatedCart = cartRepository.save(existingCart);
        return updatedCart;
    }

    @Override
    public void deleteCart(Integer id) {
        cartRepository.deleteById(id);
    }
}
