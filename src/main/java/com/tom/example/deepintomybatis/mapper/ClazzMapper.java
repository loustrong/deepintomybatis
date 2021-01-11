package com.tom.example.deepintomybatis.mapper;

import com.tom.example.deepintomybatis.entity.Clazz;
import com.tom.example.deepintomybatis.entity.ClazzMap;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface ClazzMapper {
    // 根据id查询班级信息
    @Select("SELECT * FROM tb_clazz_map  WHERE id = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="code",property="code"),
            @Result(column="name",property="name"),
            @Result(column="id",property="studentMaps",
                    many=@Many(
                            select="com.tom.example.deepintomybatis.mapper.StudentMapper.selectByClazzId",
                            fetchType= FetchType.LAZY))
    })
    ClazzMap selectById(Integer id);
}
