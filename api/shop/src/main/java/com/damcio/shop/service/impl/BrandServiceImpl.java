package com.damcio.shop.service.impl;

import com.damcio.shop.model.Brand;
import com.damcio.shop.repository.BrandRepository;
import com.damcio.shop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getBrandById(Integer id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        return optionalBrand.get();
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Brand updateBrand(Brand brand) {
        Brand existingBrand = brandRepository.findById(brand.getId()).get();
        existingBrand.setName(brand.getName());
        existingBrand.setAddress(brand.getAddress());
        existingBrand.setWebsite(brand.getWebsite());
        Brand updatedBrand = brandRepository.save(existingBrand);
        return updatedBrand;
    }

    @Override
    public void deleteBrand(Integer id) {
        brandRepository.deleteById(id);
    }
}
