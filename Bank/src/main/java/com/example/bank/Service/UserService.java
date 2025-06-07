package com.example.bank.Service;

import com.example.bank.Entity.Users;
import com.example.bank.Exception.UserCreationException;
import com.example.bank.Repository.UsersRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UserService {



    @Autowired
    UsersRepo usersRepo;
    public Users addUser(Users user) throws UserCreationException {
        try{
            log.info("Trying to add a new user");
            Users saved_User =usersRepo.save(user);
            log.info("User successfully added: {}", saved_User.getId());
            return saved_User;
        }catch (Exception e) {
            log.error("Failed to save user: {}. Error: {}", user, e.getMessage(), e);
            throw new UserCreationException("Error Occured while creating user");

        }

    }
  
    public int multiplication(Integer a, Integer b) {
        log.info("Performing addition of {} and {}", a, b);
        return a * b;
    }
    
    
    public int subtraction(Integer a, Integer b) {
        log.info("Performing subtraction of {} and {}", a, b);
        System.out.println("Performing subtraction of " + a + " and " + b);
        return a - b;
    }


    @Autowired
    DemoService demoService;
    public String  addition(Integer a,Integer b){

        if(demoService.actualaddition(a,b)>10){
            return "Greater than 10";
        }
        else
            return "Less than 10";
    }




}
