package edu.fpt.service.impl;

import edu.fpt.entity.ExamEntity;
import edu.fpt.repository.ExamRepository;
import edu.fpt.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamRepository examRepository;

    @Override
    public List<ExamEntity> findAll() {
        return examRepository.findAll();
    }

    public Optional<ExamEntity> findById(Integer integer) {
        return examRepository.findById(integer);
    }
}
