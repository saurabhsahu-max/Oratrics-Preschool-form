package com.preschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.preschool.entity.Admission;

public interface AdmissionRepository extends JpaRepository<Admission, Long> {

}