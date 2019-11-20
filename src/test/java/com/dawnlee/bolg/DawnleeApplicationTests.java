package com.dawnlee.bolg;

import com.dawnlee.bolg.dto.PaginationDto;
import com.dawnlee.bolg.dto.QuestionAndUserDto;
import com.dawnlee.bolg.mapper.QuestionMapper;
import com.dawnlee.bolg.mapper.UserMapper;
import com.dawnlee.bolg.model.Question;
import com.dawnlee.bolg.model.User;
import com.dawnlee.bolg.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.security.util.Length;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class DawnleeApplicationTests {




    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;

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

    @Test
     void test_file(){


        File file = new File("//Users//lisantao//Desktop");
        String[] list = file.list();
        System.out.println(Arrays.asList(list));
    }

    @Test
    void testac_id(){

        User byAccount = userMapper.findByAccount(String.valueOf(Integer.toString(39146624)));
        System.out.println(byAccount);
//        System.out.println(String.valueOf(39146624));
    }
}
