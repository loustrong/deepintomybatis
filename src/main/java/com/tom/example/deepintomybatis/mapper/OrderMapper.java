package com.tom.example.deepintomybatis.mapper;

import com.tom.example.deepintomybatis.entity.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface OrderMapper {

    @Select("SELECT * FROM tb_order WHERE id = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="code",property="code"),
            @Result(column="total",property="total"),
            @Result(column="user_id",property="userMap",
                    one=@One(select="com.tom.example.deepintomybatis.mapper.UserMapMapper.selectById",
                            fetchType= FetchType.EAGER)),
            @Result(column="id",property="articles",
                    many=@Many(select="com.tom.example.deepintomybatis.mapper.ArticleMapper.selectByOrderId",
                            fetchType=FetchType.LAZY))
    })
    Order selectById(Integer id);
}
