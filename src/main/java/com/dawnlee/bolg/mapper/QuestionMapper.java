package com.dawnlee.bolg.mapper;

import com.dawnlee.bolg.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
CREATE TABLE `Bolg`.`无标题`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `gmt_create` bigint(255) NULL DEFAULT NULL,
  `gmt_modify` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `creator` int(255) NULL DEFAULT NULL,
  `comment_count` int(255) NULL DEFAULT 0,
  `like_count` int(255) NULL DEFAULT 0,
  `tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `view_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
 */
@Repository
@Mapper
public interface QuestionMapper {


    @Insert("insert into question(title,description,gmt_create,gmt_modify,creator,comment_count,like_count,tag,view_count) values(#{title},#{description},#{gmtcreate},#{gmtmodify},#{creator},#{commentcount},#{likecount},#{tag},#{viewcount})")
    public void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    public List<Question> listallQuestion(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);

    @Select("select count(1) from question")
    public Integer selectCount();
}
