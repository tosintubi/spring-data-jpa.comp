package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findAllCourses(){
        List<Course> courses = courseRepository.findAll();
        courses.forEach(System.out::println);
    }


}