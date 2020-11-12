package edu.fpt.service;

import edu.fpt.entity.RoleEntity;

public interface RoleService {
    RoleEntity findByName(String name);

    <S extends RoleEntity> S save(S s);
}
