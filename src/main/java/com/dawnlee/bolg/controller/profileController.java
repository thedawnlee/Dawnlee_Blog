package com.dawnlee.bolg.controller;

import com.dawnlee.bolg.dto.PaginationDto;
import com.dawnlee.bolg.dto.QuestionAndUserDto;
import com.dawnlee.bolg.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class profileController {


    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(
            @PathVariable("action")String action,
            @RequestParam("creator_id")Integer creator_id,
            @RequestParam(name = "page",defaultValue = "1")Integer page,
            @RequestParam(name = "size",defaultValue = "5")Integer size,
            Model model){


        if ("question".equals(action)){
            model.addAttribute("section","question");
            model.addAttribute("sectionName","我的提问");


        }


       logger.info(creator_id.toString());


        PaginationDto<QuestionAndUserDto> questionAndUserDtoPaginationDto = questionService.listByCreator(page, size, creator_id);

        model.addAttribute("listallQuestion",questionAndUserDtoPaginationDto);


        return "profile";
    }
}
