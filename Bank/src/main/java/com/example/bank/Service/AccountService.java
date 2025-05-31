package com.example.bank.Service;

import com.example.bank.DTO.CreateAccountRequest;
import com.example.bank.Entity.Accounts;
import com.example.bank.Entity.Users;
import com.example.bank.Repository.AccountsRepo;
import com.example.bank.Repository.UsersRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class AccountService {

    @Autowired
    AccountsRepo accountsRepo;
    @Autowired
    UsersRepo usersRepo;


    public String newAccount(CreateAccountRequest request) {
        try{
            Optional<Users> userOpt = usersRepo.findByEmail(request.getEmail());
            if (userOpt.isEmpty()) {
                return "User with email " + request.getEmail() + " not found.";
            }

            Users user = userOpt.get();

            Accounts account = new Accounts();
            account.setUser(user);
            account.setType(request.getAccountType());
            account.setBalance(0.0);
            account.setAccountNumber(generateAccountNumber());
            account.setCreated_at(new Date());


            accountsRepo.save(account);
            log.info("New account " + account.getAccountNumber() + " created.");

            return "Account created successfully.";
        }catch(Exception e){
            log.error(e.getMessage());
            return "Account creation failed.";
        }

    }

    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis();
    }
}
