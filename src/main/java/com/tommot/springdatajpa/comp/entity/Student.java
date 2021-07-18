package com.tommot.springdatajpa.comp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "email_address_unique",
                columnNames = "email_address"
        )
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq")
    private Long studentId;
    @Column(
            name = "student_UUID",
            nullable = false
    )
    private UUID studentUUID;
    private String firstName;
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String email;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
    private LocalDateTime createdAt;

}
