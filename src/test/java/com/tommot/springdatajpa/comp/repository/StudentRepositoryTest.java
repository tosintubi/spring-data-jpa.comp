package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.Guardian;
import com.tommot.springdatajpa.comp.entity.Student;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void updateStudentByEmail(){
        studentRepository.updateStudentNameByEmail("funtusa@gmail.com","Koshemani");
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageOfThreeRecords = PageRequest.of(0,3);
        Pageable secondPageOfThreeRecords = PageRequest.of(1,3);
        Pageable lastPage = PageRequest.of(2,5);

        List<Student> students = studentRepository.findAll(secondPageOfThreeRecords).getContent();
        students.forEach(System.out::println);

        Long totalElements;
        Integer totalPages;
        totalElements = studentRepository.findAll(lastPage).getTotalElements();
        totalPages = studentRepository.findAll(secondPageOfThreeRecords).getTotalPages();

        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
    }


    @Test
    public void findAllWithSorting(){
        Pageable sortByEmail = PageRequest.of(
                0,
                4,
                Sort.by("email").ascending()
        );
        List<Student> students = studentRepository.findAll(sortByEmail).getContent();
        students.forEach(System.out::println);

        Pageable sortByFirstName = PageRequest.of(
                0,
                4,
                Sort.by("firstName").ascending()
        );

        List<Student> studentsByFirstName = studentRepository.findAll(sortByFirstName).getContent();
        studentsByFirstName.forEach(System.out::println);

        Pageable sortByFirstNameAndEmail = PageRequest.of(
                0,
                90, // test behaviour
                Sort.by("firstName")
                        .ascending()
                .and(Sort.by("email"))
        );
        List<Student> someStudents = studentRepository.findAll(sortByFirstNameAndEmail).getContent();
        someStudents.forEach(System.out::println);

    }

}