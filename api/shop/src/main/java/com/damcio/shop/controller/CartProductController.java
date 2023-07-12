package com.damcio.shop.controller;

import com.damcio.shop.model.CartProduct;
import com.damcio.shop.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartProducts")
public class CartProductController {

    @Autowired
    private CartProductService cartProductService;

    @PostMapping
    public ResponseEntity<CartProduct> createCartProduct(@RequestBody CartProduct cartProduct){
        CartProduct savedCartProduct = cartProductService.createCartProduct(cartProduct);
        return new ResponseEntity<>(savedCartProduct, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CartProduct> getCartProductById(@PathVariable("id") Integer id){
        CartProduct cartProduct = cartProductService.getCartProductById(id);
        return new ResponseEntity<>(cartProduct, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CartProduct>> getAllCartProducts() {
        List<CartProduct> cartProducts = cartProductService.getAllCartProducts();
        return new ResponseEntity<>(cartProducts, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CartProduct> updateCartProduct(@PathVariable("id") Integer id, @RequestBody CartProduct cartProduct){
        cartProduct.setId(id);
        CartProduct updatedCartProduct = cartProductService.updateCartProduct(cartProduct);
        return new ResponseEntity<>(updatedCartProduct, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCartProduct(@PathVariable("id") Integer id){
        cartProductService.deleteCartProduct(id);
        return new ResponseEntity<>("Cart Product deleted", HttpStatus.OK);
    }
}
