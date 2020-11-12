package edu.fpt.service;

import edu.fpt.entity.UserEntity;

public interface UserService {

    abstract UserEntity findByEmail(String email);

    <S extends UserEntity> S save(S s);

}
