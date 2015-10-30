package com.younggit.graduation.controller;

import com.younggit.graduation.entity.CommentEntity;
import com.younggit.graduation.entity.ItemEntity;
import com.younggit.graduation.service.CommentEntityService;
import com.younggit.graduation.service.ItemEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by lizhouyang on 15/10/21.
 */
@Controller
@RequestMapping(value = "/satisfaction/comment")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Resource
    private CommentEntityService commentEntityService;

    @Resource
    private ItemEntityService itemEntityService;

    /**
     * 注意，pageNumber从1开始计数，但Pageable中的page是从0开始计数，已在commentEntityService中做了处理
     * @param pageNumber
     * @param itemId
     * @param model
     * @return
     */
    @RequestMapping("/list/{itemId}")
    public String getCommentListPage(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                     @PathVariable Integer itemId,
                                     Model model) {
        Optional<ItemEntity> item = itemEntityService.findOne(itemId);
        if (!item.isPresent()) {
            throw new NoSuchElementException("item id: " + itemId);
        }
        model.addAttribute("item", item.get());

        Page<CommentEntity> pageEntity = commentEntityService.findAllByItemId(itemId, pageNumber);

        int curIndex = pageEntity.getNumber() + 1;
        // 手动配置页面上可加载的页数
        int beginIndex = Math.max(1, curIndex - 2);
        int endIndex = Math.min(curIndex + 2, pageEntity.getTotalPages());
        model.addAttribute("curIndex", curIndex);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        model.addAttribute("pageEntity", pageEntity);

        return "satisfaction/comment/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createCommentPage(Model model) {
        model.addAttribute(new CommentEntity());
        logger.info("request create comment pageNumber");
        return "satisfaction/comment/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createComment(@ModelAttribute CommentEntity commentEntity) {
        logger.info("request to create new comment, content: " + commentEntity.getRaw());
        commentEntity = commentEntityService.save(commentEntity);
        return "redirect:/satisfaction/comment";
    }
}
