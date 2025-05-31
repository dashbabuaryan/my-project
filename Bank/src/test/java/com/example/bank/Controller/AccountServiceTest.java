package com.example.bank.Controller;


import com.example.bank.Contoller.AccountController;
import com.example.bank.DTO.CreateAccountRequest;
import com.example.bank.Service.AccountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {
    @Mock
    AccountService accountService;

    @Mock
    CreateAccountRequest createAccountRequest;

    @InjectMocks
    AccountController accountController;

    @Test
    public void testCreateAccount() {

        Mockito.when(accountService.newAccount(createAccountRequest)).thenReturn("Account Created Successfully");
        Assert.assertEquals("<200 OK OK,Account Created Successfully,[]>", accountController.createAccount(createAccountRequest));
    }
}
