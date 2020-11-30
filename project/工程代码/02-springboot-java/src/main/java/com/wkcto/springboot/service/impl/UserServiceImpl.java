package com.wkcto.springboot.service.impl;

import com.wkcto.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * <p>
 * Package:com.wkcto.springboot.service.impl
 * Description:
 *
 * @Date:2018/8/7 9:45
 * @Author:GanHoL
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}