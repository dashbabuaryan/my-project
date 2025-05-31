package com.example.bank.Service;

import com.example.bank.Entity.Users;
import com.example.bank.Exception.UserCreationException;
import com.example.bank.Repository.UsersRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @Mock
    private UsersRepo userRepo;
    @Mock
    private DemoService demoService;
    @InjectMocks
    private UserService userService;

    @Test
    public void addUserTest() throws UserCreationException {

        Users user = new Users();
        user.setEmail("abc@gmail.com");
        user.setName("Test");
        Mockito.when(userRepo.save(user)).thenReturn(user);
        Users response = userService.addUser(user);
        Assert.assertNotNull(response);
        Assert.assertEquals(user.getName(), response.getName());
    }

    @Test
    public void addUserExceptionTest()  {
        Users user = new Users();
        Mockito.when(userRepo.save(user)).thenThrow(new UserCreationException("Will throw UserCreationException"));
        assertThrows(UserCreationException.class, () -> userService.addUser(user));
    }
    @Test
    public void additionTest()  {
        Mockito.when(demoService.actualaddition(12,34)).thenReturn(46);
        String result1=userService.addition(12,34);
       Assert.assertEquals("Greater than 10",result1);
    }

    @Test
    public void additionTestElse()  {
        Mockito.when(demoService.actualaddition(2,3)).thenReturn(5);
        Assert.assertEquals("Less than 10",userService.addition(2,3));
    }

    @Test
    public void negativeExceptionTest()  {
        Mockito.when(demoService.actualaddition(null,34)).thenThrow(new SQLException());
        assertThrows(NullPointerException.class, () -> {
            userService.addition(null, 34);
        });

    }

}
