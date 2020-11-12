package edu.fpt.service;

import edu.fpt.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentEntity> findAll();
    Optional<StudentEntity> findById(Integer integer);

    StudentEntity save(StudentEntity std);
}
