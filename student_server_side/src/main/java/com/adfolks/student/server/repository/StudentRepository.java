package com.adfolks.student.server.repository;

import com.adfolks.student.entity.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StudentRepository  extends ElasticsearchRepository<Student, String> {
}
