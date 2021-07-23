package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Course;
import com.tommot.springdatajpa.comp.entity.Student;
import com.tommot.springdatajpa.comp.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

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


    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .title("Dr.")
                .firstName("Karsten")
                .lastName("Schumacher")
                .build();

        Student student  = Student.builder()
                .firstName("Sharif")
                .lastName("Ojo")
                .email("sharifrez@gmail")
                .studentUUID(UUID.randomUUID())
                .build();

        // Cant add student each time we create a course
        Course course = Course.builder()
                .title("AI & Cybersecurity")
                .credit(6)
                .teacher(teacher)
                .build();

        // instead add student to course
        course.addStudents(student);

        courseRepository.save(course);
    }
}