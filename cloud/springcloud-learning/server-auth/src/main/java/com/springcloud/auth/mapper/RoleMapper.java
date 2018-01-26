package com.springcloud.auth.mapper;

import com.springcloud.auth.bean.UserInfo;
import org.apache.ibatis.annotations.*;


/**
 * @Auther: James Wang
 * @Data: 2018/1/8 11:07
 */

public interface RoleMapper {
    @Select("SELECT * FROM role WHERE username=#{username}")
    @Results({
            @Result(property = "userId",column = "user_id")
    })
    UserInfo login(String username);

    @Insert("INSERT INTO user(userName,authority) VALUES(#{userName},#{authority})")
    @Results({
            @Result(property = "userId",column = "user_id"),
    })
    void addOne(UserInfo user);

    @Update("UPDATE user SET userName = #{userName},authority = #{authority} WHERE id = #{id}")
    void updateOne(UserInfo user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void delOne(Integer id);
}
