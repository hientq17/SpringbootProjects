package edu.fpt.repository;

import edu.fpt.entity.ClassnameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassnameRepository extends JpaRepository<ClassnameEntity, Integer> {
}
