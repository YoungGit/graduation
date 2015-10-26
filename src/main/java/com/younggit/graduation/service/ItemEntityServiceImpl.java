package com.younggit.graduation.service;

import com.younggit.graduation.dao.ItemEntityDao;
import com.younggit.graduation.entity.ItemEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Created by lizhouyang on 15/10/22.
 */
@Service
public class ItemEntityServiceImpl implements ItemEntityService {

    @Resource
    private ItemEntityDao itemEntityDao;

    @Override
    public Optional<ItemEntity> findOne(Integer id) {
        return itemEntityDao.findOne(id);
    }

    @Override
    public List<ItemEntity> findAll() {
        return itemEntityDao.findAll();
    }

    @Override
    @Transactional
    public ItemEntity save(ItemEntity itemEntity) {
        return itemEntityDao.save(itemEntity);
    }
}
