package com.tommot.springdatajpa.comp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Table(name = "tbl_course_material")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_seq",
            sequenceName = "course_material_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne
    @JoinColumn(
            name = "course_id", // from Course Table
            referencedColumnName = "courseId"
    )
    private Course course;
}
