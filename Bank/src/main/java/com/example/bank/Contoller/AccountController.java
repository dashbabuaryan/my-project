package com.example.bank.Contoller;

import com.example.bank.DTO.CreateAccountRequest;
import com.example.bank.Entity.Accounts;
import com.example.bank.Entity.Users;
import com.example.bank.Service.AccountService;
import com.example.bank.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/accounts")

public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;
    @PostMapping("/addAccount")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest request) {
        try{

            String result = accountService.newAccount(request);
            log.info(result);

            if (result.contains("not found")) {
                return ResponseEntity.badRequest().body(result);
            }

            return ResponseEntity.ok(result);
        }catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }


    }
}
