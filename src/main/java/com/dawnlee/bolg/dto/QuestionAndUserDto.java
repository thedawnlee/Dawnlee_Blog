package com.dawnlee.bolg.dto;

import com.dawnlee.bolg.model.User;
import lombok.Data;

@Data
public class QuestionAndUserDto {


    private Integer id;
    private String title;
    private String description;
    private Long gmtcreate;
    private Long gmtmodify;
    private Integer creator;
    private Long commentcount;
    private String tag;
    private Long likecount;
    private Long viewcount;
    private User user;
}
