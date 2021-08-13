package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Course;
import com.tommot.springdatajpa.comp.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher(){
        Course devopsCourse = Course.builder()
                .title("DEVOPS - Deployment and operations")
                .credit(6)
                .build();

        Course dbtCourse = Course.builder()
                .title("DBT - Database Technology")
                .credit(6)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Mayowa")
                .lastName("Adeoya")
                //.courses(List.of(devopsCourse, dbtCourse))
                .build();

        teacherRepository.save(teacher);
    }
}