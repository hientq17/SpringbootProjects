package edu.fpt.repository;

import edu.fpt.entity.RoleEntity;
import edu.fpt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
}
