package com.devandre.supportportalbackend.service;

import com.devandre.supportportalbackend.domain.User;
import com.devandre.supportportalbackend.exception.domain.EmailExistException;
import com.devandre.supportportalbackend.exception.domain.EmailNotFoundException;
import com.devandre.supportportalbackend.exception.domain.UserNotFoundException;
import com.devandre.supportportalbackend.exception.domain.UsernameExistException;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
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

    // This method is used to register a new user when you are logged in
    User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, UsernameExistException, IOException;
    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, UsernameExistException, IOException;

    void deleteUser(long username);

    void resetPassword(String email) throws MessagingException, EmailNotFoundException;

    User updateProfileImage(String username, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, UsernameExistException, IOException;
}
