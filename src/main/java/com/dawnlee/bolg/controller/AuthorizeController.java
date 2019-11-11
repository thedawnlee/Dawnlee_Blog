package com.dawnlee.bolg.controller;

import com.dawnlee.bolg.Util.GithubUtils;
import com.dawnlee.bolg.dto.accessTokenDto;
import com.dawnlee.bolg.dto.githubUser;
import com.dawnlee.bolg.mapper.UserMapper;
import com.dawnlee.bolg.model.User;
import com.dawnlee.bolg.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class AuthorizeController {


    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    GithubUtils githubUtils;



    @Value("${github.client_id}")
    private String client_id;
    @Value("${github.client_secret}")
    private String client_secret;

    @Value("${github.redirect_uri}")
    private String redirect_uri;
    @Autowired
    UserService userService;


    @GetMapping("callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state,
                           HttpServletRequest request,
                           HttpServletResponse response){


        accessTokenDto accessTokenDto = new accessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(redirect_uri);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id(client_id);
        accessTokenDto.setClient_secret(client_secret);
        String accessToken = githubUtils.getAccessToken(accessTokenDto);
        githubUser getuser = githubUtils.getuser(accessToken);

        if(getuser!=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(getuser.getName());
            user.setAccountid(String.valueOf(getuser.getId()));
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modify(user.getGmt_create());
            User user1 = userService.insert(user);
            logger.info(user1.toString()+"插入成功");
            //登陆成功，写cookie和session
            response.addCookie(new Cookie("token",token));
            request.getSession().setAttribute("user",getuser);
            return "redirect:/";

        }else{
            //登陆失败
            return "redirect:/";


        }
        //System.out.println(getuser.getId());
//        return "redirect:index";
    }

}

