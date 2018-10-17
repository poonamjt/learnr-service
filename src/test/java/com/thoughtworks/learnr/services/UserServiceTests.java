package com.thoughtworks.learnr.services;

import com.thoughtworks.learnr.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    private UserRepository userRepository = mock(UserRepository.class);

    private UserService userService;

    public UserServiceTests ( ) {
        this.userService = new UserService( userRepository );
    }

    @Test
    public void shouldCallRepository () {
        userService.getAllItems();
        verify( userRepository, times(1 ) ).findAll();
    }
}