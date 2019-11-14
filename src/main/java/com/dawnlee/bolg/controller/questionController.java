package com.dawnlee.bolg.controller;


import com.dawnlee.bolg.dto.QuestionAndUserDto;
import com.dawnlee.bolg.model.User;
import com.dawnlee.bolg.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class questionController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(
            @PathVariable("id")Integer id,
            Model model,
            HttpServletRequest request){

        QuestionAndUserDto questionAndUserDto = questionService.findbyIdforQuestion(id);



        model.addAttribute("question",questionAndUserDto);
        logger.info(questionAndUserDto.toString());

        return "redirect:/";
    }
}
