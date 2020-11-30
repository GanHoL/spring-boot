package com.wkcto.springboot.mapper;

import com.wkcto.springboot.model.Student;

//@Mapper //把该mapper接口变成spring容器中的一个bean
public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}