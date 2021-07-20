package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Course;
import com.tommot.springdatajpa.comp.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    public void saveCourseMaterial(){
        Course someCourse = Course.builder()
                .title("Software Architecture for Blockchain Application")
                .credit(9)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("https://saba.org")
                .course(someCourse)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }
}