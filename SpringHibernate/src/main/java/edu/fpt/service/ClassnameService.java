package edu.fpt.service;

import edu.fpt.entity.ClassnameEntity;

import java.util.List;
import java.util.Optional;

public interface ClassnameService {
    List<ClassnameEntity> findAll();
    Optional<ClassnameEntity> findById(Integer integer);
}
