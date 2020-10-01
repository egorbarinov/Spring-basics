package com.egorbarinov.lesson08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;


@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("standardDate", new Date());

        return "index";
    }

}
