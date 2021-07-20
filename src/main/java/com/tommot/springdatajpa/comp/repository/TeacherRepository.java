package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Long> {
}
