package io.ethertale.reasonanddominationspringdefenseproject.web.controller;

import io.ethertale.reasonanddominationspringdefenseproject.item.model.Item;
import io.ethertale.reasonanddominationspringdefenseproject.item.repo.ItemRepo;
import io.ethertale.reasonanddominationspringdefenseproject.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;

@Controller
@RequestMapping("/items")
public class ItemsController {

    ItemRepo itemRepo;
    ItemService itemService;

    @Autowired
    public ItemsController(ItemRepo itemRepo, ItemService itemService) {
        this.itemRepo = itemRepo;
        this.itemService = itemService;
    }

    @GetMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("items");
        modelAndView.addObject("items", itemRepo.findAll().stream().sorted(Comparator.comparing(Item::getId).reversed()));
        modelAndView.setViewName("items");
        return modelAndView;
    }

    @GetMapping("/{title}")
    public ModelAndView items(@PathVariable String title) {
        ModelAndView modelAndView = new ModelAndView("items");
        modelAndView.addObject("itemSpec", itemRepo.findBySlug(title));
        modelAndView.setViewName("itemViewer");
        return modelAndView;
    }


}
