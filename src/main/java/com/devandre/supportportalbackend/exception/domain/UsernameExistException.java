package com.devandre.supportportalbackend.exception.domain;

/**
 * @author Andre Gallegos
 * @create 2022-09-29 11:42
 **/
public class UsernameExistException extends Exception {

    public UsernameExistException(String message) {
        super(message);
    }
}
