package com.dawnlee.bolg.controller;

import com.dawnlee.bolg.dto.QuestionAndUserDto;
import com.dawnlee.bolg.model.User;
import com.dawnlee.bolg.service.QuestionService;
import com.dawnlee.bolg.service.sendMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmailController {

    Logger logger = LoggerFactory.getLogger(getClass());



    @Autowired
    sendMailService  senMailService;
    @Autowired
    QuestionService questionService;

    @GetMapping("/sendmail")
    public String sendemail(

        @RequestParam("Tomail")String to,
        @RequestParam("questionid")Integer id,
        HttpServletRequest request

    ){

        logger.info("进入邮件controller");
        User user = (User)request.getSession().getAttribute("user");
        QuestionAndUserDto questionAndUserDto = questionService.findbyIdforQuestion(id);
        String description = questionAndUserDto.getDescription();
        String title = questionAndUserDto.getTitle();
        User user1 = questionAndUserDto.getUser();
        String name = user.getName();

        senMailService.sendSimpleMail(to,name+"邀请您去回答问题"+title,"问题描述:"+description+"该问题由用户"+user1.getName()+"创建");
        logger.info("发送成功");
        return "redirect:/";

    }

}
