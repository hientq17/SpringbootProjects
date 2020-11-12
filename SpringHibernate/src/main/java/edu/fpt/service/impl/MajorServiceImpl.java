package edu.fpt.service.impl;

import edu.fpt.entity.MajorEntity;
import edu.fpt.repository.MajorRepository;
import edu.fpt.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    MajorRepository majorRepository;

    @Override
    public List<MajorEntity> findAll() {
        return majorRepository.findAll();
    }

    public MajorEntity findById(Integer integer) {
        Optional<MajorEntity> optMajor = majorRepository.findById(integer);
        if(optMajor.isPresent()) return optMajor.get();
        return null;
    }

}
