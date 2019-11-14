package com.dawnlee.bolg.service.Impl;

import com.dawnlee.bolg.dto.PaginationDto;
import com.dawnlee.bolg.dto.QuestionAndUserDto;
import com.dawnlee.bolg.mapper.QuestionMapper;
import com.dawnlee.bolg.mapper.UserMapper;
import com.dawnlee.bolg.model.Question;
import com.dawnlee.bolg.model.User;
import com.dawnlee.bolg.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Override
    public PaginationDto<QuestionAndUserDto> listall(Integer page, Integer size) {

        PaginationDto<QuestionAndUserDto> questionAndUserDtoPaginationDto = new PaginationDto<>();


        Integer totalcount = questionMapper.selectCount();

        questionAndUserDtoPaginationDto.setPagination(totalcount,page,size);

        if (page<1){
            page=1;
        }
Integer integer=0;
        if (totalcount%size==0){
            integer = totalcount/size;
        }
        if (totalcount%size!=0){
            integer=totalcount/size+1;
        }

        logger.info(integer.toString()+"===================");
        if (page>integer){
            page=integer;
        }

        logger.info(questionAndUserDtoPaginationDto.getTotalPage().toString()+"共计");

        Integer offset  = size*(page-1);


        Integer count = questionMapper.selectCount();


//        Integer totalPage;
//
//        if(count%size==0){
//
//            totalPage=count/size;
//
//        }else {
//
//            totalPage = count/size+1;
//
//        }
//
//        if (page>totalPage){
//            page=totalPage;
//        }



        List<QuestionAndUserDto> questionAndUserDtoList = new ArrayList<>();

        List<Question> questions = questionMapper.listallQuestion(offset,size);
        for (Question question : questions) {


            QuestionAndUserDto questionAndUserDto = new QuestionAndUserDto();

            User creator = userMapper.findById(question.getCreator());

            BeanUtils.copyProperties(question,questionAndUserDto);
            questionAndUserDto.setUser(creator);
            questionAndUserDtoList.add(questionAndUserDto);


        }
        questionAndUserDtoPaginationDto.setData(questionAndUserDtoList);


        return questionAndUserDtoPaginationDto;
    }
}
