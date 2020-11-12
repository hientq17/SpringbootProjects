package edu.fpt.service;

import edu.fpt.entity.AnswerEntity;
import java.util.List;
import java.util.Optional;

public interface AnswerService {
    List<AnswerEntity> findAll();
    Optional<AnswerEntity> findById(Integer integer);
}
