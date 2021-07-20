package com.tommot.springdatajpa.comp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Table(name = "tbl_course_material")
// This will exclude course information when printing course materials. works with LAZY loading
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_seq",
            sequenceName = "course_material_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_seq"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY // Lazy retrieval
    )
    @JoinColumn(
            name = "course_id", // from Course Table
            referencedColumnName = "courseId"
    )
    private Course course;
}
