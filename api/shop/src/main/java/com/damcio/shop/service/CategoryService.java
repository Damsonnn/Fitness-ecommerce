package com.damcio.shop.service;

import com.damcio.shop.model.Category;
import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    Category getCategoryById(Integer id);

    List<Category> getAllCategories();

    Category updateCategory(Category category);

    void deleteCategory(Integer id);
}
