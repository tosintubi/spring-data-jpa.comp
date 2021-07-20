package com.tommot.springdatajpa.comp.repository;

import com.tommot.springdatajpa.comp.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
