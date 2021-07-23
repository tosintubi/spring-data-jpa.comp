package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Course;
import com.tommot.springdatajpa.comp.entity.CourseMaterial;
import com.tommot.springdatajpa.comp.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    public void saveCourseMaterial(){

        Teacher teacher = Teacher.builder()
                .firstName("Ingo")
                .lastName("Weber")
                .title("Prof. Dr.")
                .build();
        Course someCourse = Course.builder()
                .title("FOOCRPT- Foundation of Cryptographic Protocols")
                .credit(6)
                .teacher(teacher)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("https://foocrypt.tu-berlin.de")
                .course(someCourse)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void findAllCourseMaterial(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        courseMaterials.forEach(System.out::println);
    }
}