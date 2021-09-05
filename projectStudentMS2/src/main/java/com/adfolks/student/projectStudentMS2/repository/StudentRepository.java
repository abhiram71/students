package com.adfolks.student.projectStudentMS2.repository;

import com.adfolks.student.projectStudentMS2.entity.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StudentRepository extends ElasticsearchRepository<Student,String> {
}
