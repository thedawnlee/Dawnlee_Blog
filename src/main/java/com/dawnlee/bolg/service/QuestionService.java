package com.dawnlee.bolg.service;

import com.dawnlee.bolg.dto.PaginationDto;
import com.dawnlee.bolg.dto.QuestionAndUserDto;

import java.util.List;

public interface QuestionService {

    public PaginationDto<QuestionAndUserDto> listall(Integer page, Integer size);
}
