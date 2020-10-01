package com.egorbarinov.lesson08.service;

import com.egorbarinov.lesson08.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAll();
    void removeById(Long id);
    User getById(Long id);
    User save(User user);
    User auth(String name, String password);


}
