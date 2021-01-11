package com.tom.example.deepintomybatis.mapper;

import com.tom.example.deepintomybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @descriptions: UserMapper
 * @author: Tom
 * @date: 2021/1/10 下午 04:44
 * @version: 1.0
 */
public interface UserMapper {
    @Insert("INSERT INTO tb_user(userName,sex,age) VALUES(#{userName},#{sex},#{age})")
    @Options(useGeneratedKeys=true,keyProperty="id")
//	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,
//	statement="SELECT LAST_INSERT_ID() AS id")
    int saveUser(User user);

    @Delete("DELETE FROM tb_user WHERE id = #{id}")
    int removeUser(@Param("id") Integer id);

    @Update("UPDATE tb_user SET userName = #{userName},sex = #{sex},age = #{age} WHERE id = #{id}")
    void modifyUser(User user);

    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="userName",property="userName"),
            @Result(column="sex",property="sex"),
            @Result(column="age",property="age")
    })
    User selectUserById(@Param("id") Integer id);

    @Select("SELECT * FROM tb_user ")
    List<User> selectAllUser();
    @Select("SELECT MAX(id) FROM tb_user")
    int selectMaxId();

}
