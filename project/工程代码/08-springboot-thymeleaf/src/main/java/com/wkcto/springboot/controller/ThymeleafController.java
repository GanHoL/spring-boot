package com.wkcto.springboot.controller;

import com.wkcto.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * ClassName:ThymeleafController
 * <p>
 * Package:com.wkcto.springboot.controller
 * Description:
 *
 * @Date:2018/8/10 11:25
 * @Author:GanHoL
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/boot/index")
    public String index (HttpSession session, Model model) {

        model.addAttribute("data", "Spring boot集成 Thymeleaf！");

        User user = new User();
        user.setId(1);
        user.setNick("zhangsanf");
        user.setPhone("13700020000");
        user.setEmail("111@163.com");
        user.setAddress("beijing");

        model.addAttribute("user", user);

        List<User> userList = new ArrayList<>();

        Map<String, User> userMap = new HashMap<String, User>();

        User[] userArray = new User[12];

        Map<String, Object> map = new HashMap<String, Object>();

        int[] intArray = new int[12];
        for (int i=0; i<12; i++) {
            User u = new User();
            u.setId(1);
            u.setNick("zhangsanf");
            u.setPhone("13700020000");
            u.setEmail("111@163.com");
            u.setAddress("beijing");

            userList.add(u);
            userMap.put(String.valueOf(i), u);
            userArray[i] = u;
            intArray[i] = i;
        }
        map.put("1", userList);

        List<User> userList2 = new ArrayList<>();


        for (int i=0; i<5; i++) {
            User u = new User();
            u.setId(i);
            u.setNick("zhangsanf"+i);
            u.setPhone("1370002000"+i);
            u.setEmail(i+"111@163.com");
            u.setAddress("beijing"+i);

            userList2.add(u);
        }
        map.put("2", userList2);

        model.addAttribute("userList", userList);
        model.addAttribute("userMap", userMap);
        model.addAttribute("userArray", userArray);

        model.addAttribute("map", map);

        model.addAttribute("sex", 2);

        model.addAttribute("nowDate", new Date());

        model.addAttribute("nowDateStr", "2018-08-11 10:54:03");

        model.addAttribute("intArray", intArray);

        //return 中就是你页面的名字（不带.html后缀）
        return "index";
    }
}