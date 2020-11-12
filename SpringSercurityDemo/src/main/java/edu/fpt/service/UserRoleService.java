package edu.fpt.service;

import edu.fpt.entity.UserRoleEntity;

public interface UserRoleService {
    <S extends UserRoleEntity> S save(S s);
}
