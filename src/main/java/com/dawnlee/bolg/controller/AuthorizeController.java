package com.dawnlee.bolg.controller;

import com.dawnlee.bolg.Util.GithubUtils;
import com.dawnlee.bolg.dto.accessTokenDto;
import com.dawnlee.bolg.dto.githubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    GithubUtils githubUtils;



    @Value("${github.client_id}")
    private String client_id;
    @Value("${github.client_secret}")
    private String client_secret;

    @Value("${github.redirect_uri}")
    private String redirect_uri;



    @GetMapping("callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state){


        accessTokenDto accessTokenDto = new accessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(redirect_uri);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id(client_id);
        accessTokenDto.setClient_secret(client_secret);
        String accessToken = githubUtils.getAccessToken(accessTokenDto);
        githubUser getuser = githubUtils.getuser(accessToken);


        System.out.println(getuser.getId());
        return "index";
    }

}

