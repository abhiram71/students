package com.adfolks.student.projectStudentMS1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private String studentrollno;
    private String studentName;
    private String studentClass;
    private String studentMark;

}
