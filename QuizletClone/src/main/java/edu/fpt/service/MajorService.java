package edu.fpt.service;

import edu.fpt.entity.MajorEntity;

import java.util.List;
import java.util.Optional;

public interface MajorService {
    List<MajorEntity> findAll();
    Optional<MajorEntity> findById(Integer integer);
}
