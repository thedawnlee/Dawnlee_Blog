package com.dawnlee.bolg;

import com.dawnlee.bolg.dto.PaginationDto;
import com.dawnlee.bolg.dto.QuestionAndUserDto;
import com.dawnlee.bolg.mapper.QuestionMapper;
import com.dawnlee.bolg.model.Question;
import com.dawnlee.bolg.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class DawnleeApplicationTests {




    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionMapper questionMapper;

    @Test
    void contextLoads() {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(1550);
        list.add(5);
        list.add(5);
        list.add(6666);

        Integer max = Collections.max(list);
        System.out.println(max);


    }

    @Test
    void testdto(){


//        List<Question> byCreator = questionMapper.findByCreator(8);


  //      System.out.println(byCreator);


    }

    @Test
    void testcreator_question(){

        PaginationDto<QuestionAndUserDto> questionAndUserDtoPaginationDto = questionService.listByCreator(2, 5, 8);


        PaginationDto<QuestionAndUserDto> listall = questionService.listByCreator(1,5,8);

//        System.out.println(listall.getData());

        System.out.println(questionAndUserDtoPaginationDto.getData());


    }
}
