package com.dawnlee.bolg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class profileController {


    @GetMapping("/profile/{action}")
    public String profile(
            @PathVariable("action")String action,
            Model model){


        if ("question".equals(action)){
            model.addAttribute("section","question");
            model.addAttribute("sectionName","我的提问");


        }


        return "profile";
    }
}
