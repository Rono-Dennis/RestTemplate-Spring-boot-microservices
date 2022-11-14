package com.example.userservice.service;

import com.example.userservice.connection.Department;
import com.example.userservice.connection.ResponseTemplate;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside userService save user");
        return userRepository.save(user);
    }

    public ResponseTemplate getUserWithDepartments(Long userId){
        ResponseTemplate responseTemplate =new ResponseTemplate();//http://localhost:9090/department/
        User user = userRepository.findByUserId(userId);//http://DEPARTMENT-SERVICE/department/
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+ user.getDepartmentId(), Department.class);

        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);

        return responseTemplate;
    }
}
