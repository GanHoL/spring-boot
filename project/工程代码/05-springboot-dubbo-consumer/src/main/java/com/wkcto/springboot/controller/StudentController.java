package com.wkcto.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wkcto.springboot.model.Student;
import com.wkcto.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:StudentController
 * <p>
 * Package:com.wkcto.springboot.controller
 * Description:
 *
 * @Date:2018/8/7 12:25
 * @Author:GanHoL
 */
@Controller
public class StudentController {

    //引用远程dubbo服务
    @Reference(timeout = 10000) //dubbo的注解，相当于xml中的<dubbo:reference id="xx" interface="xxx">
    private StudentService studentService;

    @RequestMapping("/boot/student")
    public String student(Model model) {

        Student student = studentService.getStudentById(1);

        model.addAttribute("student", student);

        return "index";
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