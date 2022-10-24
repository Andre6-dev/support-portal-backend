package com.devandre.supportportalbackend.exception.domain;

/**
 * @author Andre Gallegos
 * @create 2022-09-29 11:42
 **/
public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }
}
