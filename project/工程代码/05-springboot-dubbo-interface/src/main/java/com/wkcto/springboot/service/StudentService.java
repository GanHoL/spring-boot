package com.wkcto.springboot.service;

import com.wkcto.springboot.model.Student;

/**
 * ClassName:StudentService
 * <p>
 * Package:com.wkcto.springboot.service
 * Description:
 *
 * @Date:2018/8/7 12:20
 * @Author:GanHoL
 */
public interface StudentService {

    public Student getStudentById(Integer id);

    public int updateStudent(Student student);

}
