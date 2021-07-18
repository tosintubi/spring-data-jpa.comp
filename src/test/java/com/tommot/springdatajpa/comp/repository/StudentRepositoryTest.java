package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Guardian;
import com.tommot.springdatajpa.comp.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .email("hojhn@hotmail.com")
                .firstName("John")
                .lastName("Odugbenga")
                /*.guardianEmail("odugb.hj@gmail.com")
                .guardianName("Michael Ajayi")
                .guardianMobile("0809291281212")*/
                .studentUUID(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Lateef K")
                .email("latkee@aol.net")
                .mobile("+1764353636")
                .build();

        Student student = Student.builder()
                .email("funtusaj@gmail.com")
                .firstName("Funto")
                .lastName("S Aanuoluwa")
                .guardian(guardian)
                .studentUUID(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> allStudents = studentRepository.findAll();
        System.out.printf("Student List = " + allStudents);

    }
}