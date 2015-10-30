package com.younggit.graduation.dao;

import com.younggit.graduation.entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by lizhouyang on 15/10/22.
 */
public interface CommentEntityDao extends BaseRepository<CommentEntity, Integer> {
    Page<CommentEntity> findByItemId(Integer id, Pageable pageRequest);
}
