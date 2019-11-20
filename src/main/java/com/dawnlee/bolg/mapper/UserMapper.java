package com.dawnlee.bolg.mapper;


import com.dawnlee.bolg.dto.githubUser;
import com.dawnlee.bolg.model.Question;
import com.dawnlee.bolg.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,accountid,token,gmt_create,gmt_modify,avatar_url) values(#{name},#{accountid},#{token},#{gmtcreate},#{gmtmodify},#{avatarUrl})")
    public void insertUser(User user);

    @Select("select * from user where token=#{token}")
    public User findByToken(String token);

    @Select("select * from user where id=#{id}")
    public User findById(@Param("id") Integer id);

    @Select("select * from user where accountid = #{accountid}")
    public User findByAccount(String accountid);

    @Update("update user set name=#{name},token=#{token},gmt_modify=#{gmtmodify},avatar_url=#{avatarUrl} where id=#{id}")
    public void updateUser(User user);


}
