package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Guardian;
import com.tommot.springdatajpa.comp.entity.Student;
import lombok.AllArgsConstructor;
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
                .email("hjkojhn@hotmail.com")
                .firstName("AJohn")
                .lastName("KOdugbenga")
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
                .name("Hannes")
                .email("hannes@aol.net")
                .mobile("+1764353636")
                .build();

        Student student = Student.builder()
                .email("moanne@gmail.com")
                .firstName("Moyinoluwalogo")
                .lastName("Annelore")
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
    @Test
    public void findStudentByEmail(){
        Student student = studentRepository.findStudentByEmail("tosin@gmail.com");
        System.out.println(student);
    }

    @Test
    public void findStudentByEmailNativeNamedParam(){
        Student student = studentRepository.findStudentByEmailNativeNamedParam("tosin@gmail.com");
        System.out.println(student);
    }

   @Test
    public void findStudentsByFirstName(){
        List<Student> students = studentRepository.findByFirstName("funto");
        System.out.println("Number of Students: "+ students.size());
        students.forEach(System.out::println);
        //System.out.println("Students: "+ students);
    }
    @Test
    public void findStudentByFirstOrLastNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContainingOrLastNameContaining("olu", "ade");
        System.out.println("Number of Students: "+ students.size());
        students.forEach(System.out::println);
    }

    @Test
    public void findStudentByFirstNameNotNull(){
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("Number of Students: "+ students.size());
        students.forEach(System.out::println);
    }

    @Test
    public void findStudentByGuardianNull(){
        List<Student> students = studentRepository.findByGuardianNull();
        System.out.println("Number of Students: "+ students.size());
        students.forEach(System.out::println);
    }

}