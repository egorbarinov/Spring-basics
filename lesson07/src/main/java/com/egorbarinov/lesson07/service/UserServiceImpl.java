package com.egorbarinov.lesson07.service;

import com.egorbarinov.lesson07.domain.User;
import com.egorbarinov.lesson07.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Transactional
@Service
@Repository
public class UserServiceImpl implements UserService {

    @PersistenceContext
    protected EntityManager entityManager;

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
        init();
    }

    private void init(){
         // String name, String email, int age, Date date
        userDAO.saveAll(Arrays.asList(
                new User("Vasya Lozhkin", "vasya@gmail.com", 40, new Date()),
                new User("Geogry Zhukov", "zhorik@gmail.com", 67, new Date()),
                new User("Evgeny Sidorov", "evgen@mail.ru", 38, new Date()),
                new User("Roman Dudakov", "roman@gmail.com", 41, new Date()),
                new User("Margo Fedorova", "margo@mail.ru", 39, new Date()),
                new User("Varya Chesnokova", "varya@list.ru", 12, new Date())
        ));

    }


    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }

    @Override
    public User getById(Long id) {
        return userDAO.getOne(id);
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public List<User> getByAge(int ageFrom, int ageTo) {
        return userDAO.findAllByAgeBetween(ageFrom, ageTo);
    }

    @Override
    public void removeById(Long id) {
        userDAO.deleteUserById(id);

    }
}
