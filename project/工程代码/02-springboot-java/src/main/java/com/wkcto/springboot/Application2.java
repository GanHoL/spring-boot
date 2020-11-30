package com.wkcto.springboot;

import com.wkcto.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application2 implements CommandLineRunner {

	@Autowired
	private UserService userService;

	/**
	 * 这是我们业务方法入口
	 *
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		String hi = userService.sayHi("张无忌");
		System.out.println(hi);
	}

	/**
	 * 这是springboot程序入口
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		//启动springboot程序，启动spring容器
		SpringApplication.run(Application2.class, args);

		/*SpringApplication springApplication = new SpringApplication(Application2.class);
		springApplication.setBannerMode(Banner.Mode.OFF);//关闭springboot的日志logo输出
		springApplication.run(args);*/
	}
}