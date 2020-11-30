package com.wkcto.springboot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:RestFullController
 * <p>
 * Package:com.wkcto.springboot.controller
 * Description:
 *
 * @Date:2018/8/9 12:19
 * @Author:GanHoL
 */
@RestController //采用restfull开发，通常是开发接口，返回json格式的数据，不跳转到页面，但是采用restfull开发也可以跳转页面
public class RestFullController {

    // http://localhost:8080/01-springboot-web/boot/order/1521/1
    // http://localhost:8080/01-springboot-web/boot/order/1/1521
    @GetMapping("/boot/order/{id}/{status}") //查询
    public Object order (@PathVariable("id") Integer id, @PathVariable("status") Integer status) {

        Map<String, Object> map = new HashMap<String, Object>();

        //调用底层service，查询数据库数据 (省略)
        map.put("id", id);
        map.put("status", status);
        map.put("name", "购买手机");

        System.out.println("get方法被执行......");

        return map;
    }

    // http://localhost:8080/01-springboot-web/boot/1521/order/1
    @RequestMapping("/boot/{id}/order/{status}")
    public Object order1 (@PathVariable("id") Integer id, @PathVariable("status") Integer status) {

        Map<String, Object> map = new HashMap<String, Object>();

        //调用底层service，查询数据库数据 (省略)
        map.put("id", id);
        map.put("status", status);
        map.put("name", "购买手机");

        return map;
    }

    // http://localhost:8080/01-springboot-web/boot/order/1521/1
    @PostMapping("/boot/order/{id}/{status}") //新增数据
    public Object order2 (@PathVariable("id") Integer id, @PathVariable("status") Integer status) {

        Map<String, Object> map = new HashMap<String, Object>();

        //调用底层service，查询数据库数据 (省略)
        map.put("id", id);
        map.put("status", status);
        map.put("name", "购买手机");

        System.out.println("post方法被执行......");

        return map;
    }

    //@RequestMapping(value="/boot/order", method = {RequestMethod.POST, RequestMethod.GET})
    // http:localhost:8080/01-springboot-web/boot/order/1/1521
    @PutMapping("/boot/order/{status}/{id}") //
    public Object order3 (@PathVariable("id") Integer id, @PathVariable("status") Integer status) {

        Map<String, Object> map = new HashMap<String, Object>();

        //调用底层service，查询数据库数据 (省略)
        map.put("id", id);
        map.put("status", status);
        map.put("name", "购买手机");

        return map;
    }
}
