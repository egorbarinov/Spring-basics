package com.egorbarinov.lesson08.controller;

import com.egorbarinov.lesson08.domain.User;
import com.egorbarinov.lesson08.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/userlist")
    public String allusers(Model model, User user) {
        List<User> users = userService.getAll();
        model.addAttribute("viewUser", user);
        model.addAttribute("users", users);

        return "userlist";
    }

}
