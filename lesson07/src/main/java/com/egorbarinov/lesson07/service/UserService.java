package com.egorbarinov.lesson07.service;

import com.egorbarinov.lesson07.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long id);

    User save(User user);

    List<User> getByAge(int ageFrom, int ageTo);

    void removeById(Long id);
}
