package com.tom.example.deepintomybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 使用註解注入時,需要指明需要掃描的包
@MapperScan(value={"com.tom.example.deepintomybatis.dao",
		"com.tom.example.deepintomybatis.mapper"})
public class DeepintomybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeepintomybatisApplication.class, args);
	}

}
