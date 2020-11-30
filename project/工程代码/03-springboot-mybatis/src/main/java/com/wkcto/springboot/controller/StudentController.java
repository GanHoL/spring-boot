package com.wkcto.springboot.controller;

import com.wkcto.springboot.model.Student;
import com.wkcto.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:StudentController
 * <p>
 * Package:com.wkcto.springboot.controller
 * Description:
 *
 * @Date:2018/8/7 12:25
 * @Author:GanHoL
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/boot/student")
    public Object student() {

        return studentService.getStudentById(1);
    }

    @RequestMapping("/boot/insert")
    public Object insertStudent() {
        Student student = new Student();
        return studentService.insertStudent(student);
    }

    @RequestMapping("/boot/update")
    public Object updateStudent() {

        Student student = new Student();
        student.setId(1);
        student.setAge(18);
        student.setName("张三丰-update");
        return studentService.updateStudent(student);
    }
}
