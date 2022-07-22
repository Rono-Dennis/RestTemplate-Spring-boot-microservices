package com.example.userservice.controller;


import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside controller save user");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUsersWithDepartment(@PathVariable("id") Long userId) {
        log.info("inside getUserWithResponse of UserController");
        return userService.getUserWithDepartment(userId);
    }

}
