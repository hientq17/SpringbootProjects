package edu.fpt.service.impl;

import edu.fpt.entity.ClassnameEntity;
import edu.fpt.repository.ClassnameRepository;
import edu.fpt.service.ClassnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassnameServiceImpl implements ClassnameService {
    @Autowired
    ClassnameRepository classnameRepository;

    @Override
    public List<ClassnameEntity> findAll() {
        return classnameRepository.findAll();
    }

    public Optional<ClassnameEntity> findById(Integer integer) {
        return classnameRepository.findById(integer);
    }
}
