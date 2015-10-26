package com.younggit.graduation.service;

import com.younggit.graduation.entity.ItemEntity;
import java.util.List;
import java.util.Optional;

/**
 * Created by lizhouyang on 15/10/22.
 */
public interface ItemEntityService {
    public Optional<ItemEntity> findOne(Integer id);
    public List<ItemEntity> findAll();
    public ItemEntity save(ItemEntity itemEntity);
}
