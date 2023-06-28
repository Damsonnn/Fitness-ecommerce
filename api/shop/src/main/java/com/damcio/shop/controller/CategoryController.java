package com.damcio.shop.controller;

import com.damcio.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/products")
public class CategoryController {

    private CategoryService customerService;
    @GetMapping
    public void listCategories() {

    }

}
