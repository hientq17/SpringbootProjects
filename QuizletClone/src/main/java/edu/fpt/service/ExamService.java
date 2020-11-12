package edu.fpt.service;

import edu.fpt.entity.ExamEntity;
import java.util.List;
import java.util.Optional;

public interface ExamService {
    List<ExamEntity> findAll();
    Optional<ExamEntity> findById(Integer integer);
}
