package com.damcio.shop.service;

import com.damcio.shop.model.Brand;

import java.util.List;

public interface BrandService {
    Brand createBrand(Brand brand);

    Brand getBrandById(Integer id);

    List<Brand> getAllBrand();

    Brand updateBrand(Brand category);

    void deleteBrand(Integer id);
}
