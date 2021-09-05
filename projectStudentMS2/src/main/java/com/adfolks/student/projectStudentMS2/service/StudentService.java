package com.adfolks.student.projectStudentMS2.service;

import com.adfolks.student.projectStudentMS2.entity.Student;

public interface StudentService {
    Student saveStudents(Student student);

    void deletestudentrollno(String studentrollno);
}
