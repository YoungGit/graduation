package com.younggit.graduation.service;

import com.younggit.graduation.entity.CommentEntity;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by lizhouyang on 15/10/29.
 */
public interface CommentEntityService {
    CommentEntity save(CommentEntity commentEntity);
    Optional<CommentEntity> findOne(int id);
    Page<CommentEntity> findAllByItemId(Integer id, int pageNumber);
}
