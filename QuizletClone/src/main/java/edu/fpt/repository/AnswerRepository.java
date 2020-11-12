package edu.fpt.repository;

import edu.fpt.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity,Integer> {
}
