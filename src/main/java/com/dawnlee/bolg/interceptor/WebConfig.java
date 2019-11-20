package com.dawnlee.bolg.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    Myinterceptor myinterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        String[] strings = {"/", "/static/**"};
        registry.addInterceptor(myinterceptor).addPathPatterns("/**").excludePathPatterns("/index.html",
                "/login/*","/question/**","/","/static/**","*.js","*.css","/callback","/profile/**","/sendmail","/publish");
    }
}
