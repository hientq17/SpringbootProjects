package edu.fpt.repository;

import edu.fpt.entity.MajorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<MajorEntity,Integer> {
}
