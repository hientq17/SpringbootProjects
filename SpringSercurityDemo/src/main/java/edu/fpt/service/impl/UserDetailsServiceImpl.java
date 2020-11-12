package edu.fpt.service.impl;

import edu.fpt.entity.UserEntity;
import edu.fpt.entity.UserRoleEntity;
import edu.fpt.repository.UserRepository;
import edu.fpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userService.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Collection<UserRoleEntity> roles = user.getUserRolesById();
        //get all roles of user
        for (UserRoleEntity role : roles) {
            System.out.println("ROLE: "+role.getRoleByRoleId().getName());
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleByRoleId().getName()));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
