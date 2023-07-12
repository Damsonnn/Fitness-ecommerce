package com.damcio.shop.service.impl;

import com.damcio.shop.model.CartProduct;
import com.damcio.shop.repository.CartProductRepository;
import com.damcio.shop.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CartProductServiceImpl implements CartProductService {

    @Autowired
    private CartProductRepository cartProductRepository;

    @Override
    public CartProduct createCartProduct(CartProduct cartProduct) {
        cartProduct.setPriceOfProducts();
        return cartProductRepository.save(cartProduct);
    }

    @Override
    public CartProduct getCartProductById(Integer id) {
        Optional<CartProduct> optionalCartProduct = cartProductRepository.findById(id);
        return optionalCartProduct.get();
    }

    @Override
    public List<CartProduct> getAllCartProducts() {
        return cartProductRepository.findAll();
    }

    @Override
    public CartProduct updateCartProduct(CartProduct cartProduct) {
        CartProduct existingCartProduct = cartProductRepository.findById(cartProduct.getId()).get();
        existingCartProduct.setCart(cartProduct.getCart());
        existingCartProduct.setQuantity(cartProduct.getQuantity());
        existingCartProduct.setProduct(cartProduct.getProduct());
        existingCartProduct.setPriceOfProducts();
        CartProduct updatedCartProduct = cartProductRepository.save(existingCartProduct);
        return updatedCartProduct;
    }

    @Override
    public void deleteCartProduct(Integer id) {
        cartProductRepository.deleteById(id);
    }
}
