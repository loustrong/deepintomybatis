package com.tom.example.deepintomybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tom.example.deepintomybatis.dao")
public class DeepintomybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeepintomybatisApplication.class, args);
	}

}
