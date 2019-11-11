package com.dawnlee.bolg.service.Impl;


import com.dawnlee.bolg.mapper.QuestionMapper;
import com.dawnlee.bolg.model.Question;
import com.dawnlee.bolg.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishServiceImpl implements PublishService {


    @Autowired
    QuestionMapper questionMapper;



    @Override
    public int createQuestion(Question question) {
        questionMapper.create(question);
        return 0;
    }
}
