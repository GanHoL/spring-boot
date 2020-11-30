package com.wkcto.springboot.controller;

import com.wkcto.springboot.model.Users;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:WebController
 * <p>
 * Package:com.wkcto.springboot.controller
 * Description:
 *
 * @Date:2018/8/7 10:40
 * @Author:GanHoL
 */
@RestController //等价于 @Controller + @ResponseBody
public class WebController {

    //@RestController注解，那么controller下的所有方法都是返回json或者返回字符串

    @RequestMapping("/boot/user")
    public Object user() {

        Users user = new Users();
        user.setId(1);
        user.setName("张三丰");
        user.setPhone("13700000000");
        return user;
    }
}