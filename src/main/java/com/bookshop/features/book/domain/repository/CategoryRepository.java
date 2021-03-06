package com.bookshop.features.book.domain.repository;


import com.bookshop.features.book.data.entity.CategoryEntity;
import com.bookshop.features.book.data.entity.SubcategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    List<CategoryEntity> getCategories();

    CategoryEntity saveCategory(CategoryEntity category);

    Optional<CategoryEntity> getCategory(int id);

    Optional<SubcategoryEntity> getSubcategoryById(Integer subcategoryId);
}
