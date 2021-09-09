package com.adfolks.student.server.service;

import com.adfolks.student.entity.Student;

public interface StudentService {

    Student saveStudents(Student student);
    void deletestudentrollno(String studentrollno);

}
