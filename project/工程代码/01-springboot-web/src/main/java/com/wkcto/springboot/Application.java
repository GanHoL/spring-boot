package com.wkcto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication //springboot的全局的自动配置注解
@ServletComponentScan(basePackages={"com.wkcto.springboot.servlet", "com.wkcto.springboot.filter"})
public class Application {

	//spring boot项目包结构（建议），主类在最外层包下，其他业务类在主类的子包下

	//package : 主类：       com.wkcto.springboot

	//package : 其他业务类：  com.wkcto.springboot.controller

	public static void main(String[] args) {

		//固定的代码，启动springboot程序，初始化spring容器
		SpringApplication.run(Application.class, args);

	}
}