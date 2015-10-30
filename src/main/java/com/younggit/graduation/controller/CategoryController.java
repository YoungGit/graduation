package com.younggit.graduation.controller;

import com.younggit.graduation.entity.CategoryEntity;
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
 * Created by lizhouyang on 15/10/29.
 */
@Controller
@RequestMapping(value = "/satisfaction/category")
public class CategoryController {

    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private CategoryEntityService categoryEntityService;

    @RequestMapping
    public String getCategoryList(Model model) {
        logger.info("request all category entities");
        List<CategoryEntity> categoryList = categoryEntityService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "satisfaction/category/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createCategoryPage(Model model) {
        model.addAttribute(new CategoryEntity());
        logger.info("request create category page");
        return "satisfaction/category/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCategory(@ModelAttribute CategoryEntity categoryEntity) {
        logger.info("request to create new category entity with name : " + categoryEntity.getName());
        categoryEntity = categoryEntityService.save(categoryEntity);
        return "redirect:/satisfaction/category/" + categoryEntity.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getCategoryById(@PathVariable("id") int id, Model model) {
        logger.info("request category entity, id : " + id);
        Optional<CategoryEntity> category = categoryEntityService.findOne(id);
        if (!category.isPresent()) {
            logger.info("can't get category entity, id : " + id);
            return "redirect:satisfaction/category/list";
        }
        model.addAttribute("category", category.get());
        return "satisfaction/category/show";
    }
}
