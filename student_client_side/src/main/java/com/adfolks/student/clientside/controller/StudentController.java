package com.adfolks.student.clientside.controller;

import com.adfolks.student.clientside.MQconfig;
import com.adfolks.student.clientside.service.StudentService;
import com.adfolks.student.entity.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/")
    public String funClass() {
        return "Welcome...";
    }

}
