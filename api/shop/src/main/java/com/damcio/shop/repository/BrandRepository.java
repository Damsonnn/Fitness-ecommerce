package com.damcio.shop.repository;

import com.damcio.shop.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository  extends JpaRepository<Brand, Integer> {
}
