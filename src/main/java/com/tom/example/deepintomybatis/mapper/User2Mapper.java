package com.tom.example.deepintomybatis.mapper;

import com.tom.example.deepintomybatis.entity.User2;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * @descriptions: User2Mapper
 * @author: Tom
 * @date: 2021/1/10 下午 09:03
 * @version: 1.0
 */
// 開啟二級緩存
@CacheNamespace(eviction= LruCache.class,flushInterval=60000,size=512,
        readWrite=true)
public interface User2Mapper {
    /**
     * 插入数据
     * @param user 包含要查询的User信息
     */
    @Insert("{call insert_user(#{user_id,mode=OUT,jdbcType=INTEGER},"
            + "#{user_name,mode=IN},#{user_sex,mode=IN},#{user_age,mode=IN})}")
    @Options(statementType= StatementType.CALLABLE)
    void saveUser(User2 user);

    /**
     * 查询所有数据
     * @return List<User> 包含所有User数据的List集合
     */
    @Select("{call select_user()}")
    @Options(statementType=StatementType.CALLABLE)
    List<User2> selectUser();

    /**
     * 根据id查询对应的数据
     * @param id 用户的id
     * @return User 包含用户信息的User对象
     */
    @Select("{call select_user_by_id(#{user_id,mode=IN})}")
    @Options(statementType=StatementType.CALLABLE)
    User2 selectUserById(Integer id);

    /**
     * 修改数据
     * @param user 包含要修改的User信息
     */
    @Update("{call update_user(#{user_id,mode=IN},#{user_name,mode=IN},#{user_sex,mode=IN},#{user_age,mode=IN})}")
    @Options(statementType=StatementType.CALLABLE)
    void modifyUser(User2 user);

    /**
     * 删除数据
     * @param user 包含要修改的User信息
     */
    @Delete("{call delete_user_by_id(#{user_id,mode=IN})}")
    @Options(statementType=StatementType.CALLABLE)
    void removeUser(User2 user);

}
