package com.tom.example.deepintomybatis.mapper;

import com.tom.example.deepintomybatis.entity.Card;
import org.apache.ibatis.annotations.Select;

public interface CardMapper {
    @Select("SELECT * FROM tb_card WHERE ID = #{id} ")
    Card selectCardById(Integer id);
}
