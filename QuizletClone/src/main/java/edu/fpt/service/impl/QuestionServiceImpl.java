package edu.fpt.service.impl;

import edu.fpt.entity.QuestionEntity;
import edu.fpt.repository.QuestionRepository;
import edu.fpt.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<QuestionEntity> findAll() {
        return questionRepository.findAll();
    }

    public Optional<QuestionEntity> findById(Integer integer) {
        return questionRepository.findById(integer);
    }
}
