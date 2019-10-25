package com.dawnlee.bolg.controller;

import com.dawnlee.bolg.model.User;
import com.dawnlee.bolg.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class indexController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String indexhello(HttpServletResponse response, HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies==null){return "index";}
        for (Cookie cookie : cookies) {

            if ("token".equals(cookie.getName())) {
                String token = cookie.getValue();
                User user = userService.findByToken(token);
                logger.info("进入判断");
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }

        }
            return "index";
        }



}