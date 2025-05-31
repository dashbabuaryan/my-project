package com.example.bank.Controller;

import com.example.bank.Contoller.UsersController;
import com.example.bank.Entity.Users;
import com.example.bank.Service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
    @Mock
    UserService userService;

    @InjectMocks
    UsersController userController;

    @Test
    public void addUserTest(){
        Users user = new Users();
        Mockito.when(userService.addUser(user)).thenReturn(user);
        Assert.assertEquals(userService.addUser(user), user);
    }

    @Test
    public void addUserExceptionTest(){
        Users user = new Users();
        Mockito.when(userService.addUser(user)).thenThrow(new RuntimeException());
        Assert.assertEquals(userService.addUser(user), user);
    }

}
