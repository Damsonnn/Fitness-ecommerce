package com.damcio.shop.controller;

import com.damcio.shop.model.Cart;
import com.damcio.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        Cart savedCart = cartService.createCart(cart);
        return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id") Integer id){
        Cart cart = cartService.getCartById(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable("id") Integer id, @RequestBody Cart cart){
        cart.setId(id);
        Cart updatedCart = cartService.updateCart(cart);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCart(@PathVariable("id") Integer id){
        cartService.deleteCart(id);
        return new ResponseEntity<>("Cart deleted", HttpStatus.OK);
    }
}
