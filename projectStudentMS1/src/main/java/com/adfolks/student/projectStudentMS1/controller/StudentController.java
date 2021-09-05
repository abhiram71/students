package com.adfolks.student.projectStudentMS1.controller;

import com.adfolks.student.projectStudentMS1.MQconfig;
import com.adfolks.student.projectStudentMS1.entity.Student;
import com.adfolks.student.projectStudentMS1.service.StudentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        template.convertAndSend(MQconfig.EXCHANGE, MQconfig.ROUTING_KEY_SAVE, student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public String saveStudent1(@PathVariable("id") String studentrollno) {
        template.convertAndSend(MQconfig.EXCHANGE, MQconfig.ROUTING_KEY_DELETE, studentrollno);
        return "Deleted";
    }
//    @GetMapping("/students")
//    public List<Student> fetchStudents() {
//        template.ge(MQconfig.EXCHANGE, MQconfig.ROUTING_KEY_GET, student);
//        return Student;
//    }

    @GetMapping("/")
    public String root() {
        return "Welcome to the game";
    }

}
