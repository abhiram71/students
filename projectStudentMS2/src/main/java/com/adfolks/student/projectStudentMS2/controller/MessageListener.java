package com.adfolks.student.projectStudentMS2.controller;

import com.adfolks.student.projectStudentMS2.MQconfig;
import com.adfolks.student.projectStudentMS2.entity.Student;
import com.adfolks.student.projectStudentMS2.service.StudentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageListener {
    @Autowired
    private StudentService studentService;


    @RabbitListener(queues = MQconfig.QUEUESAVE)
        public  void saveStudents(Student student){
          studentService.saveStudents(student);
        }
    @RabbitListener(queues = MQconfig.QUEUEDELETE)
    public  void saveStudent(String studentrollno){
        System.out.println(studentrollno);
        studentService.deletestudentrollno(studentrollno);
    }

}
