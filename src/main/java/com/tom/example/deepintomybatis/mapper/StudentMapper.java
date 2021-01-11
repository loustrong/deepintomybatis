package com.tom.example.deepintomybatis.mapper;

import com.tom.example.deepintomybatis.entity.Student;
import com.tom.example.deepintomybatis.entity.StudentMap;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    // 根据班级id查询班级所有学生
    @Select("SELECT * FROM tb_student_map WHERE clazz_id = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="age",property="age")
    })
    List<StudentMap> selectByClazzId(Integer clazz_id);
}
