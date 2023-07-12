package com.damcio.shop.controller;

import com.damcio.shop.model.Brand;
import com.damcio.shop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand){
        Brand savedBrand = brandService.createBrand(brand);
        return new ResponseEntity<>(savedBrand, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("id") Integer id){
        Brand brand = brandService.getBrandById(id);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands(){
        List<Brand> brands = brandService.getAllBrand();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable("id") Integer id, @RequestBody Brand brand){
        brand.setId(id);
        Brand updatedBrand = brandService.updateBrand(brand);
        return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable("id") Integer id){
        brandService.deleteBrand(id);
        return new ResponseEntity<>("Brand deleted", HttpStatus.OK);
    }
}
