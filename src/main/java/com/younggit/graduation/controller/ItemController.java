package com.younggit.graduation.controller;

import com.younggit.graduation.entity.CategoryEntity;
import com.younggit.graduation.entity.ItemEntity;
import com.younggit.graduation.service.CategoryEntityService;
import com.younggit.graduation.service.ItemEntityService;
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
@RequestMapping("/satisfaction/item")
public class ItemController {

    private Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Resource
    private CategoryEntityService categoryEntityService;

    @Resource
    private ItemEntityService itemEntityService;

    @RequestMapping
    public String getItemList(Model model) {
        logger.info("request all item entities");
        Iterable<ItemEntity> itemList = itemEntityService.findAll();
        model.addAttribute("itemList", itemList);
        return "satisfaction/item/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createItemPage(Model model) {
        logger.info("request create item page");
        List<CategoryEntity> categoryList = categoryEntityService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("item", new ItemEntity());
        return "satisfaction/item/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createItem(@ModelAttribute("item") ItemEntity item) {
        logger.info("request to create new item entity with name : " + item.getName());
        item = itemEntityService.save(item);
        return "redirect:/satisfaction/item/" + item.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getItemById(@PathVariable Integer id, Model model) {
        logger.info("request item entity, id " + id);
        Optional<ItemEntity> itemEntityOptional = itemEntityService.findOne(id);
        if (!itemEntityOptional.isPresent()) {
            logger.info("can't get item, id : " + id);
            return "redirect:satisfaction/item/list";
        }
        model.addAttribute("item", itemEntityOptional.get());
        return "satisfaction/item/show";
    }
}
