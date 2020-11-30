package com.wkcto.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wkcto.springboot.mapper.UserInfoMapper;
import com.wkcto.springboot.model.UserInfo;
import com.wkcto.springboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName:UserInfoServiceImpl
 * <p>
 * Package:com.wkcto.springboot.service.impl
 * Description:
 *
 * @Date:2018/8/11 11:18
 * @Author:GanHoL
 */
@Component //spring的注解
@Service(timeout = 10000, interfaceClass = UserInfoService.class) //dubbo的注解，发布dubbo服务
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * springboot自动初始化的，不需要我们进行配置，直接可以注入到代码中使用
     */
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public int deleteUserInfoById(Integer id) {
        int delete = userInfoMapper.deleteByPrimaryKey(id);

        if (delete > 0) {
            //删除用户后，把redis对应的用户缓存也要删除
            redisTemplate.delete(String.valueOf(id));
        }
        return delete;
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        int update = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if (update > 0) {
            //数据库用户更新了，对应的redis缓存也需要更新
            redisTemplate.opsForValue().set(String.valueOf(userInfo.getId()), userInfo);
        }
        return update;
    }

    @Override
    public UserInfo getUserInfoById(Integer id) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //查询缓存
        UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get(String.valueOf(id));
        //判断缓存是否为空
        if (null == userInfo) {
            //双重检测锁实现
            synchronized (this) {
                userInfo = (UserInfo) redisTemplate.opsForValue().get(String.valueOf(id));
                if (null == userInfo) {
                    //查询数据库
                    userInfo = userInfoMapper.selectByPrimaryKey(id);
                    //放入缓存
                    redisTemplate.opsForValue().set(String.valueOf(id), userInfo);
                }
            }
        }
        return userInfo;
    }

    @Override
    public List<UserInfo> getUserInfoByPage(Integer startRow, Integer limit) {
        return userInfoMapper.selectUserInfoByPage(startRow, limit);
    }

    @Override
    public int getUserInfoByTotals() {
        return userInfoMapper.selectUserInfoByTotals();
    }
}