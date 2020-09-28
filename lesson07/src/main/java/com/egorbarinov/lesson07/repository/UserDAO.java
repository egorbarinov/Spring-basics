package com.egorbarinov.lesson07.repository;


import com.egorbarinov.lesson07.domain.Product;
import com.egorbarinov.lesson07.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


public interface UserDAO extends JpaRepository<User, Long> {

    List<User> findByName(String username);
    List<User> findAllByAgeBetween(int startAge, int endAge);
    void deleteUserById(long id);
}
