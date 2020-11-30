package com.wkcto.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wkcto.springboot.mapper.StudentMapper;
import com.wkcto.springboot.model.Student;
import com.wkcto.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:StudentServiceImpl
 * <p>
 * Package:com.wkcto.springboot.service.impl
 * Description:
 *
 * @Date:2018/8/9 11:13
 * @Author:GanHoL
 */
@Component
@Service(timeout = 10000, retries = 0) //dubbo的注解, 相当于xml中的 <dubbo:service interface="xxx" ref="xxx">
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Transactional //对该方法进行事务管理，如果该方法抛出异常，事务就会回滚
    @Override
    public int updateStudent(Student student) {

        int update = studentMapper.updateByPrimaryKeySelective(student);

        int a = 10 / 0; //0不能作为除数，会抛出运行时异常

        return update;
    }
}