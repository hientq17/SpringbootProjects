package edu.fpt.repository;

import edu.fpt.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamEntity,Integer> {
}
