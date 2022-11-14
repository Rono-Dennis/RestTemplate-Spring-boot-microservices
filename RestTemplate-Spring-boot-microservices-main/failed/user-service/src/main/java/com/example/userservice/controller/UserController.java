package com.example.userservice.controller;


import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside controller save user");
        return userService.saveUser(user);
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUsersWithDepartment(@PathVariable("id") Long userId) {
        log.info("inside getUserWithResponse of UserController");


        return userService.getUserWithDepartments(userId);
    }

}
