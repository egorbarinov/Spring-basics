package com.egorbarinov.lesson08.service;

import com.egorbarinov.lesson08.domain.User;
import com.egorbarinov.lesson08.repository.UserDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getById(Long id) {
        return userDAO.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public User auth(String username, String password) {
        if(username == null || username.isEmpty()){
            System.out.println("You are not authenticated");
            return null;
        }
        User user = userDAO.findFirstByName(username);
        if(user == null){
            System.out.println("You are not authenticated");
            return null;
        }
        if(!Objects.equals(password, user.getPassword())){
            System.out.println("You are not authenticated");
            return null;
        }
        System.out.println("You are authenticated");
        return user;
    }

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }

    @Override
    public void removeById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findFirstByName(username);
    }

}


