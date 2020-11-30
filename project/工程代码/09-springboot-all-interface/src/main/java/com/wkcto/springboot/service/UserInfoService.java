package com.wkcto.springboot.service;

import com.wkcto.springboot.model.UserInfo;

import java.util.List;

/**
 * ClassName:UserInfoService
 * <p>
 * Package:com.wkcto.springboot.service
 * Description:
 *
 * @Date:2018/8/11 11:11
 * @Author:GanHoL
 */
public interface UserInfoService {

    public int addUserInfo(UserInfo userInfo);

    public int deleteUserInfoById(Integer id);

    public int updateUserInfo(UserInfo userInfo);

    public UserInfo getUserInfoById(Integer id);

    public List<UserInfo> getUserInfoByPage(Integer startRow, Integer limit);

    public int getUserInfoByTotals();
}
