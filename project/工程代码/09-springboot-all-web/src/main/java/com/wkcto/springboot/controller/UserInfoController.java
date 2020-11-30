package com.wkcto.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wkcto.springboot.commons.Constants;
import com.wkcto.springboot.model.UserInfo;
import com.wkcto.springboot.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:UserInfoController
 * <p>
 * Package:com.wkcto.springboot.controller
 * Description:
 *
 * @Date:2018/8/11 11:57
 * @Author:GanHoL
 */
@Controller
public class UserInfoController {

    //引用远程dubbo服务
    @Reference
    private UserInfoService userInfoService;

    /**
     * RestFull原则：
     * 1、请求路径中建议不要使用动词，用名词 ,比如添加用户/api/adduser有动词, 应该用/api/user
     *    动词在请求方法中体现：4种请求方法 @PostMapping
     *
     * 2、不同请求应该采用不同的请求方法，
     *    新增操作使用@PostMapping，修改@PutMapping, 删除@DeleteMapping，查询@GetMapping
     *
     * 3、如果是对数据过滤、排序、分页等操作，使用 ?参数名=xxx 的方式, 不是所有的参数都是用斜杆/来请求
     *    http://localhost:8080/api/order?p=23&sort=asc
     *
     *
     * 说明：restFull风格主要是用来开发接口的，返回json数据，当然也可以用来跳转到页面（使用少一些）
     *
     * @return
     */
    @GetMapping("/all/users")
    public String users(Model model, @RequestParam(value="p", required = false) Integer curPage) {

        if (null == curPage) {
            curPage = 1;
        }
        int startRow = (curPage - 1) * Constants.PAGE_SIZE;

        List<UserInfo> userInfoList = userInfoService.getUserInfoByPage(startRow, Constants.PAGE_SIZE);

        int totalRows = userInfoService.getUserInfoByTotals();
        //计算分页
        int totalPages = totalRows / Constants.PAGE_SIZE;
        int left = totalRows % Constants.PAGE_SIZE;
        if (left > 0) {
            totalPages = totalPages + 1;
        }

        model.addAttribute("userInfoList", userInfoList);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);

        return "users";
    }

    /**
     * 去添加用户
     *
     * @return
     */
    @GetMapping("/all/user")
    public String toAddUser() {

        return "user";
    }

    /**
     * 添加用户
     *
     * @param userInfo
     * @return
     */
    @PostMapping("/all/user")
    public String addUser(UserInfo userInfo) {

        userInfoService.addUserInfo(userInfo);

        //重定向到用户列表页
        return "redirect:/all/users";
    }

    /**
     * 去修改
     *
     * @param id
     * @return
     */
    @GetMapping("/all/user/{id}")
    public String toUpdateUser(Model model, @PathVariable("id") Integer id) {

        UserInfo userInfo = userInfoService.getUserInfoById(id);

        model.addAttribute("userInfo", userInfo);

        //添加用户 和 修改用户 共用一个表单页面
        return "user";
    }

    /**
     * 修改用户
     *
     * @param userInfo
     * @return
     */
    @PutMapping("/all/user")
    public String updateUser(UserInfo userInfo) {

        userInfoService.updateUserInfo(userInfo);

        //重定向到用户列表页
        return "redirect:/all/users";
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/all/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {

        userInfoService.deleteUserInfoById(id);

        //重定向到用户列表页
        return "redirect:/all/users";
    }
}