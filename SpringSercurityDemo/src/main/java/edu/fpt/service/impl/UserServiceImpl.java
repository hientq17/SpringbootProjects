package edu.fpt.service.impl;

import edu.fpt.entity.UserEntity;
import edu.fpt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements edu.fpt.service.UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public <S extends UserEntity> S save(S s) {
        return userRepository.save(s);
    }


}
