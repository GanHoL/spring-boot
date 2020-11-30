package com.wkcto.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:JSPController
 * <p>
 * Package:com.wkcto.springboot.controller
 * Description:
 *
 * @Date:2018/8/7 10:52
 * @Author:GanHoL
 */
@Controller
public class JSPController {

    /**
     * 跳转到JSP
     *
     * @param model
     * @return
     */
    @RequestMapping("/boot/jsp")
    public String jsp (Model model) {

        model.addAttribute("msg", "Springboot使用JSP.");

        return "index";
    }
}