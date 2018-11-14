package com.thoughtworks.learnr.services;

import com.thoughtworks.learnr.models.User;
import com.thoughtworks.learnr.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void setUp() {
        this.userService = new UserService( userRepository );
    }

    @Test
    public void shouldCallRepositoryFindAllMethod() {
        userService.getAllItems();
        verify( userRepository, times(1 ) ).findAll();
    }

    @Test
    public void shouldCallRepositorySaveMethod(){
        String name = "testUser";
        Long userId = 12l;
        userService.addUser(userId, name);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save( userArgumentCaptor.capture() );

        User actualUser = userArgumentCaptor.getValue();

        Assert.assertEquals( name, actualUser.getName());
        Assert.assertEquals( userId, actualUser.getUserId());
    }


}