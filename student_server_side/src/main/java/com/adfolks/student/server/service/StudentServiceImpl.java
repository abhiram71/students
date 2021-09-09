package com.adfolks.student.server.service;

import com.adfolks.student.entity.Student;
import com.adfolks.student.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudents(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deletestudentrollno(String studentrollno) {
        studentRepository.deleteById(studentrollno);
    }
}
