package com.tom.example.deepintomybatis.mapper;

import com.tom.example.deepintomybatis.entity.UserMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapMapper {
    @Select("SELECT * FROM tb_user_map WHERE id = #{id} ")
    UserMap selectById(Integer id);
}
