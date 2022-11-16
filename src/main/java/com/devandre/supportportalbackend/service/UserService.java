package com.devandre.supportportalbackend.service;

import com.devandre.supportportalbackend.domain.User;
import com.devandre.supportportalbackend.exception.domain.EmailExistException;
import com.devandre.supportportalbackend.exception.domain.UserNotFoundException;
import com.devandre.supportportalbackend.exception.domain.UsernameExistException;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Interface for user service
 *
 * @author Andre Gallegos
 * @create 2022-09-28 12:14
 **/
public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, EmailExistException, UsernameExistException, MessagingException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
