package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianNull();

    List<Student> findByGuardianName(String guardianName);

    @Query("Select s from Student s where s.email = ?1")
    Student findStudentByEmail(String emailAddress);

}
