package com.dawnlee.bolg.mapper;


import com.dawnlee.bolg.dto.githubUser;
import com.dawnlee.bolg.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,accountid,token,gmt_create,gmt_modify) values(#{name},#{accountid},#{token},#{gmt_create},#{gmt_modify})")
    public void insertUser(User user);

    @Select("select * from user where token=#{token}")
    public User findByToken(String token);

}
