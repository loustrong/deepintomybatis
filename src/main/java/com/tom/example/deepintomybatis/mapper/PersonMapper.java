package com.tom.example.deepintomybatis.mapper;

import com.tom.example.deepintomybatis.entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface PersonMapper {
    @Select("SELECT * FROM tb_person WHERE ID = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="age",property="age"),
            @Result(column="card_id",property="card",
                    one=@One(
                            select="com.tom.example.deepintomybatis.mapper.CardMapper.selectCardById",
                            fetchType= FetchType.EAGER))
    })
    Person selectPersonById(Integer id);
}
