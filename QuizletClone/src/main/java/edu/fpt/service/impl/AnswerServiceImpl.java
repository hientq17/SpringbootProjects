package edu.fpt.service.impl;

import edu.fpt.entity.AnswerEntity;
import edu.fpt.repository.AnswerRepository;
import edu.fpt.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository anwserRepository;

    @Override
    public List<AnswerEntity> findAll() {
        return anwserRepository.findAll();
    }

    public Optional<AnswerEntity> findById(Integer integer) {
        return anwserRepository.findById(integer);
    }
}
