package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository  extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

    List<Student> findByLastNameNotNull(String lastName);

    List<Student> findByGuardianName(String guardianName);

}
