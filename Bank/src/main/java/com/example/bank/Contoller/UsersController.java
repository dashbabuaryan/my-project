package com.example.bank.Contoller;

import com.example.bank.Entity.Users;
import com.example.bank.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/users")

public class UsersController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody Users user) {
        try{
            userService.addUser(user);
            log.info("User added successfully");
            return "User added successfully";
        }
        catch(Exception e){
            log.error(e.getMessage());
            return "Error occured while adding user";
        }
    }



}
