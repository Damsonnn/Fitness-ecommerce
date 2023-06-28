package com.damcio.shop.service;

import com.damcio.shop.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Product getProductById(Integer id);

    List<Product> getAllProduct();

    Product updateProduct(Product product);

    void deleteProduct(Integer id);

}