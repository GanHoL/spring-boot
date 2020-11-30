package com.wkcto.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = "com.wkcto.springboot.mapper")
@SpringBootApplication
@EnableTransactionManagement //开启事务管理支持
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
