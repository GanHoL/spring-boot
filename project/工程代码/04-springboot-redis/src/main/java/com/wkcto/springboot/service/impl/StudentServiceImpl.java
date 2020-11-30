package com.wkcto.springboot.service.impl;

import com.wkcto.springboot.mapper.StudentMapper;
import com.wkcto.springboot.model.Student;
import com.wkcto.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:StudentServiceImpl
 * <p>
 * Package:com.wkcto.springboot.service.impl
 * Description:
 *
 * @Date:2018/8/7 12:21
 * @Author:GanHoL
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * springboot自动初始化的，不需要我们进行配置，直接可以注入到代码中使用
     */
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public /*synchronized*/ Student getStudentById(Integer id) {

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //查询缓存
        Student student = (Student) redisTemplate.opsForValue().get("studentKey");

        //判断缓存是否为空
        if (null == student) {

            //双重检测锁实现
            synchronized (this) {
                student = (Student) redisTemplate.opsForValue().get("studentKey");

                if (null == student) {
                    System.out.println("查询了数据库......");
                    //查询数据库
                    student = studentMapper.selectByPrimaryKey(id);
                    //放入缓存
                    redisTemplate.opsForValue().set("studentKey", student);
                }
            }

        } else {
            System.out.println("查询了缓存......");
        }
        return student;
    }

    @Transactional //对该方法进行事务管理，如果该方法抛出异常，事务就会回滚
    @Override
    public int updateStudent(Student student) {

        int update = studentMapper.updateByPrimaryKeySelective(student);

        int a = 10 / 0; //0不能作为除数，会抛出运行时异常

        return update;
    }
}