package com.egorbarinov.lesson07.controller;

import com.egorbarinov.lesson07.domain.User;
import com.egorbarinov.lesson07.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    // http://localhost:8080/app/products - GET
    @RequestMapping(method = RequestMethod.GET)  // выводит форматированным json всех users
    public List<User> list(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return users;
    }

    @GetMapping("/delete/{id}")
    public List deleteProductById(@PathVariable("id") Long id, Model model) { // удаляет user по id и возвращает лист оставшихся users
        userService.removeById(id);

        List<User> users = userService.getAll();;
        model.addAttribute("users", users);
        return users;
    }


    // http://localhost:8080/app/users/new - GET
    @GetMapping("/new")                              // не придумал, как можно задействовать
    public String getFormNewUser(Model model){
        model.addAttribute("user", new User());
        return "new-user";
    }

    // http://localhost:8080/app/users/new - POST
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewUser(User user){
        User savedUser = userService.save(user);
        System.out.println(savedUser);
        return "redirect:/users/";
    }

}
