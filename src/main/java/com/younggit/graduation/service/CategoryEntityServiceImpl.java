package com.younggit.graduation.service;

import com.younggit.graduation.dao.CategoryEntityDao;
import com.younggit.graduation.entity.CategoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by lizhouyang on 15/10/21.
 */
@Service
public class CategoryEntityServiceImpl implements CategoryEntityService {

    private Logger logger = LoggerFactory.getLogger(CategoryEntityServiceImpl.class);

    @Autowired
    private CategoryEntityDao categoryEntityDao;

    @Override
    @Transactional
    public CategoryEntity save(CategoryEntity category) {
        logger.debug("save category with name : " + category.getName());
        CategoryEntity createCategory = category;
        return categoryEntityDao.save(createCategory);
    }

    @Override
    public Optional<CategoryEntity> findOne(int id) {
        logger.debug("find category by id : " + id);
        return categoryEntityDao.findOne(id);
    }

    @Override
    public List<CategoryEntity> findAll() {
        logger.info("find all categories");
        return categoryEntityDao.findAll();
    }
}
