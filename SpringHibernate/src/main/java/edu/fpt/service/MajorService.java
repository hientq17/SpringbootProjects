package edu.fpt.service;

import edu.fpt.entity.MajorEntity;

import java.util.List;

public interface MajorService {
    List<MajorEntity> findAll();
    MajorEntity findById(Integer integer);
}
