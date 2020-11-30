package com.wkcto.springboot.mapper;

import com.wkcto.springboot.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * mybatis传多个参数
     * 1、用Map传
     * 2、用对象传
     * 3、用注解@Param传
     *
     * @param startRow
     * @param limit
     * @return
     */
    List<UserInfo> selectUserInfoByPage(@Param("startRow") Integer startRow, @Param("limit") Integer limit);

    int selectUserInfoByTotals();
}