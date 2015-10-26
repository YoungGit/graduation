package com.younggit.graduation.service;

import com.younggit.graduation.entity.CategoryEntity;
import java.util.List;
import java.util.Optional;

/**
 * Created by lizhouyang on 15/10/21.
 */
public interface CategoryEntityService {
    public CategoryEntity save(CategoryEntity category);
    public Optional<CategoryEntity> findOne(int id);
    public List<CategoryEntity> findAll();
}
