package com.wkcto.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:WarController
 * <p>
 * Package:com.wkcto.springboot.controller
 * Description:
 *
 * @Date:2018/8/10 9:31
 * @Author:GanHoL
 */
@Controller
public class WarController {

    @GetMapping("/boot/json")
    public @ResponseBody Object json() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1208);
        map.put("status", 1);
        map.put("name", "购买手机");

        return map;
    }

    @GetMapping("/boot/jsp")
    public String jsp (Model model) {
        model.addAttribute("data", "返回jsp页面");

        return "index";
    }
}