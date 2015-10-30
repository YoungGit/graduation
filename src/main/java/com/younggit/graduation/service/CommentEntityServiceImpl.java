package com.younggit.graduation.service;

import com.younggit.graduation.dao.CommentEntityDao;
import com.younggit.graduation.entity.CommentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by lizhouyang on 15/10/29.
 */
@Service
public class CommentEntityServiceImpl implements CommentEntityService {

    private static final int PAGE_SIZE = 10;

    private static Logger logger = LoggerFactory.getLogger(CommentEntityServiceImpl.class);

    @Autowired
    private CommentEntityDao commentEntityDao;

    @Transactional
    @Override
    public CommentEntity save(CommentEntity commentEntity) {
        commentEntity = commentEntityDao.save(commentEntity);
        logger.info("save CommentEntity, id : " + commentEntity.getId());
        return commentEntity;
    }

    @Override
    public Optional<CommentEntity> findOne(int id) {
        return commentEntityDao.findOne(id);
    }

    @Override
    public Page<CommentEntity> findAllByItemId(Integer id, int pageNumber) {
        return commentEntityDao.findByItemId(id, new PageRequest(pageNumber - 1, PAGE_SIZE));
    }


}
