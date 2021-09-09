package com.adfolks.student.server.controller;

import com.adfolks.student.entity.Student;
import com.adfolks.student.server.MQconfig;
import com.adfolks.student.server.service.StudentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageListener {
    @Autowired
    private StudentService studentService;

    @RabbitListener(queues = MQconfig.QUEUESAVE)
    public void saveStudents(Student student) {
        studentService.saveStudents(student);
    }

    @RabbitListener(queues = MQconfig.QUEUEDELETE)
    public void saveStudent(String studentrollno) {
        studentService.deletestudentrollno(studentrollno);
    }

}
