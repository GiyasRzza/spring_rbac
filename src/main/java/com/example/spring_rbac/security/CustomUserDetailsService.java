package com.example.spring_rbac.security;

import com.example.spring_rbac.dao.RoleDao;
import com.example.spring_rbac.dao.UserDao;
import com.example.spring_rbac.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao user = userRepository.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException("UserName not found!"));
        return  new User(user.getUserName(),user.getPassword(),mapRoleToAuthorities(user.getRole()));

    }
    private Collection<GrantedAuthority> mapRoleToAuthorities(List<RoleDao> roles){
        return roles.stream().map(roleDao -> new
                SimpleGrantedAuthority(roleDao.getRoleName())).collect(Collectors.toList());
    }
}
