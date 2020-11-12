package edu.fpt.service.impl;
import edu.fpt.entity.UserRoleEntity;
import edu.fpt.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements edu.fpt.service.UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public <S extends UserRoleEntity> S save(S s) {
        return userRoleRepository.save(s);
    }
}
