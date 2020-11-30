package com.wkcto.springboot;

import com.wkcto.springboot.service.UserService;
import com.wkcto.springboot.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

//@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		//spring方式：
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		//springboot 的 run 方法返回了一个spring容器对象
		ApplicationContext context = SpringApplication.run(Application.class, args);

		UserService userService = context.getBean("userServiceImpl", UserServiceImpl.class);

		String hi = userService.sayHi("张三丰");

		System.out.println(hi);
	}
}
