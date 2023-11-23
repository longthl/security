package com.example.security.controller;

import com.example.security.Service.Impl.UserService;
import com.example.security.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
private final UserService userService;
@PostMapping("/new")
    public String addUser(@RequestBody UserInfo userInfo){
    return userService.addUser(userInfo);
}
}
