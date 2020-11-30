package com.wkcto.springboot.controller;

import com.wkcto.springboot.model.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:HelloController
 * <p>
 * Package:com.wkcto.springboot.controller
 * Description:
 *
 * @Date:2018/8/7 9:04
 * @Author:GanHoL
 */
@Controller
public class HelloController {

    /**
     * 读取自定义配置
     */
    @Value("${info.site.url}")
    private String url;

    /**
     * 读取自定义配置
     */
    @Value("${info.site.tel}")
    private String tel;

    @Autowired
    private ConfigInfo configInfo;


    @RequestMapping("/boot/hello")
    public @ResponseBody String hello () {
        return "Hello, Spring Boot.";
    }

    @RequestMapping("/boot/config")
    public @ResponseBody String config () {
        return url + "---" + tel + "--->" + configInfo.getUrl() + "---" + configInfo.getTel();
    }
}