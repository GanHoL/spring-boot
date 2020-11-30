package com.wkcto.springboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDubboConfiguration //开启dubbo的自动配置的支持
@EnableTransactionManagement //开启事务管理支持
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}