package com.younggit.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lizhouyang on 15/10/19.
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
