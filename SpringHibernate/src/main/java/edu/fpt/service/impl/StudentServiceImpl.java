package edu.fpt.service.impl;

import edu.fpt.entity.StudentEntity;
import edu.fpt.repository.StudentRepository;
import edu.fpt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> findById(Integer integer) {
        return studentRepository.findById(integer);
    }

    @Override
    public StudentEntity save(StudentEntity std) {
        return studentRepository.save(std);
    }
}
