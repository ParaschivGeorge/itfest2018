package com.twoguysonepanda.itfest2018.controller;

import com.twoguysonepanda.itfest2018.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
