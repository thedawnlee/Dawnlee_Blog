package com.dawnlee.bolg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.dawnlee.bolg.mapper")
@EnableCaching
@SpringBootApplication
public class DawnleeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DawnleeApplication.class, args);
    }

}
