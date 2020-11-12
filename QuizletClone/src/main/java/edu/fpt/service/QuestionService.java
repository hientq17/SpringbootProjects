package edu.fpt.service;

import edu.fpt.entity.QuestionEntity;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<QuestionEntity> findAll();
    Optional<QuestionEntity> findById(Integer integer);
}
