package com.tom.example.deepintomybatis.mapper;

import com.tom.example.deepintomybatis.entity.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {
    @Select("SELECT * FROM tb_article WHERE id IN "
            +"(SELECT article_id FROM tb_item WHERE order_id = #{id} ) ")
    List<Article> selectByOrderId(Integer order_id);

}
