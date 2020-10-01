package com.egorbarinov.lesson08.repository;


import com.egorbarinov.lesson08.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User, Long> {

    User findFirstByName(String name);

}
