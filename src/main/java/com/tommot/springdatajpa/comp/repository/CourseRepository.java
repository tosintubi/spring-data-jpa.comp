package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
