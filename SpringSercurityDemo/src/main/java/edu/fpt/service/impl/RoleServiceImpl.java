package edu.fpt.service.impl;

import edu.fpt.entity.RoleEntity;
import edu.fpt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements edu.fpt.service.RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public RoleEntity findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public <S extends RoleEntity> S save(S s) {
        return roleRepository.save(s);
    }
}
