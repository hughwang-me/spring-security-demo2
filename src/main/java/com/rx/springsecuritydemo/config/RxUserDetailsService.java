package com.rx.springsecuritydemo.config;

import com.rx.springsecuritydemo.entity.Users;
import com.rx.springsecuritydemo.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RxUserDetailsService implements UserDetailsService {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.warn("登录用户名:{}", s);
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin,query");

//        List<GrantedAuthority> auths = AuthorityUtils
//                .commaSeparatedStringToAuthorityList("addUser,findAll,ROLE_admin,ROLE_user");


        Users users = usersMapper.selectByUsername(s);

        return new User(s, passwordEncoder.encode(users.getPassword()), auths);
    }
}
