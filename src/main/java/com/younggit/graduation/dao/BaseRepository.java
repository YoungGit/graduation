package com.younggit.graduation.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by lizhouyang on 15/10/22.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
    List<T> findAll();
    Page<T> findAll(Pageable pageRequest);
    Optional<T> findOne(ID id);
    T save(T entity);
}
