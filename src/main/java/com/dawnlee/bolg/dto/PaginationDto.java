package com.dawnlee.bolg.dto;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
@Data
public class PaginationDto<T> {
    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;


    Logger logger = LoggerFactory.getLogger(getClass());
    public void setPagination(Integer totalCount,Integer page,Integer size){
        Integer totalPage = 0;

        if(totalCount%size==0){

            totalPage=totalCount/size;

        }else {

            totalPage = totalCount/size+1;

        }


        this.totalPage = totalPage;

        if (page<1){
            page=1;
        }
        if (page>totalPage){
            page=totalPage;
        }
        this.page = page;
        pages.add(page);
        for(int i =1;i<=3;i++){

            if (page-i>0){

                pages.add(0,page-i);
            }
            if (page+i<=totalPage){

                pages.add(page+i);
            }


        }


        logger.info(pages.toString());

logger.info(totalCount.toString()+"数据条");
        this.totalPage = totalCount;
        logger.info(totalPage.toString()+"页数");
        this.page = page;
        if(page==1){

            showFirstPage = false;


        }else{

            showFirstPage = true;
        }
        if(page ==totalPage){

            showNext = false;

        }else {

            showNext = true;

        }
        if(pages.contains(1)){


            showPrevious=false;
        }else {


            showPrevious = true;
        }

        if (pages.contains(totalPage)){


            showEndPage = false;

        }else {


            showEndPage = true;
        }

        logger.info("=====================");
        System.out.println(showPrevious);
        System.out.println(showFirstPage);
        logger.info("=====================");


    }

}
