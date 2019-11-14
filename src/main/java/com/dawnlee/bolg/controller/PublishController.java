package com.dawnlee.bolg.controller;

import com.dawnlee.bolg.mapper.QuestionMapper;
import com.dawnlee.bolg.model.Question;
import com.dawnlee.bolg.model.User;
import com.dawnlee.bolg.service.PublishService;
import com.dawnlee.bolg.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {


    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @Autowired
    PublishService publishService;




    @GetMapping("publish")
    public String publish(){


        return "publish";
    }


    @PostMapping("publish")
    public String dopublish(
            @RequestParam("title")String title,
            @RequestParam("description")String description,
            @RequestParam("tag")String tag,
            HttpServletRequest request,
            Model model

    ){

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if(StringUtils.isEmpty(title)){

            model.addAttribute("error","title is not empty");

            return "publish";
        }
        if(StringUtils.isEmpty(description)){

            model.addAttribute("error","title is not empty");

            return "publish";
        }
        if(StringUtils.isEmpty(tag)){

            model.addAttribute("error","title is not empty");

            return "publish";
        }

//        User user;
//        int userid=0;
//        Cookie[] cookies = request.getCookies();
//        if (cookies==null){return "index";}
//        for (Cookie cookie : cookies) {
//
//            if ("token".equals(cookie.getName())) {
//                String token = cookie.getValue();
//               user = userService.findByToken(token);
//                logger.info("进入判断");
//                if (user != null) {
//                    userid=user.getId();
//                }
//                break;
//            }
//
//        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }



    Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setGmtcreate(System.currentTimeMillis());
        question.setGmtmodify(System.currentTimeMillis());
        question.setCreator(user.getId());
        publishService.createQuestion(question);

        logger.info("success");

        return "redirect:/";

    }


}
