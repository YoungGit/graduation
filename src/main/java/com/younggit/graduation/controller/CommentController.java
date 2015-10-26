package com.younggit.graduation.controller;

import com.younggit.graduation.dao.ItemEntityDao;
import com.younggit.graduation.entity.CategoryEntity;
import com.younggit.graduation.entity.ItemEntity;
import com.younggit.graduation.service.CategoryEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Created by lizhouyang on 15/10/21.
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Resource
    private CategoryEntityService categoryEntityService;
    @Resource
    private ItemEntityDao itemEntityDao;

    @RequestMapping(value = "/category/create", method = RequestMethod.GET)
    public String createCategoryPage(Model model) {
        model.addAttribute(new CategoryEntity());
        logger.info("request create category page");
        return "comment/category/create";
    }

    @RequestMapping(value = "/category/create", method = RequestMethod.POST)
    public String createCategory(@ModelAttribute CategoryEntity categoryEntity) {
        logger.info("request to create new category entity with name : " + categoryEntity.getName());
        categoryEntity = categoryEntityService.save(categoryEntity);
        return "redirect:/comment/category/" + categoryEntity.getId();
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public String getCategoryById(@PathVariable("id") int id, Model model) {
        logger.info("request category entity, id : " + id);
        Optional<CategoryEntity> category = categoryEntityService.findOne(id);
        if (!category.isPresent()) {
            logger.info("can't get category entity, id : " + id);
            return "redirect:comment/category/list";
        }
        model.addAttribute("category", category.get());
        return "comment/category/show";
    }

    @RequestMapping("/category")
    public String getCategoryList(Model model) {
        logger.info("request all category entities");
        List<CategoryEntity> categoryList = categoryEntityService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "comment/category/list";
    }

    @RequestMapping(value = "/item/create", method = RequestMethod.GET)
    public String createItemPage(Model model) {
        logger.info("request create item page");
        List<CategoryEntity> categoryList = categoryEntityService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("item", new ItemEntity());
        return "comment/item/create";
    }

    @RequestMapping(value = "/item/create", method = RequestMethod.POST)
    public String createItem(@ModelAttribute("item") ItemEntity item) {
        logger.info("request to create new item entity with name : " + item.getName());
        item = itemEntityDao.save(item);
        return "redirect:/comment/item/" + item.getId();
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String getItemById(@PathVariable Integer id, Model model) {
        logger.info("request item entity, id " + id);
        Optional<ItemEntity> itemEntityOptional = itemEntityDao.findOne(id);
        if (!itemEntityOptional.isPresent()) {
            logger.info("can't get item, id : " + id);
            return "redirect:comment/item/list";
        }
        model.addAttribute("item", itemEntityOptional.get());
        return "comment/item/show";
    }

    @RequestMapping("/item")
    public String getItemList(Model model) {
        logger.info("request all item entities");
        Iterable<ItemEntity> itemList = itemEntityDao.findAll();
        model.addAttribute("itemList", itemList);
        return "comment/item/list";
    }
}
