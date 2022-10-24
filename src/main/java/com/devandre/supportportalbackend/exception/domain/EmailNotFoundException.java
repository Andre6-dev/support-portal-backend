package com.devandre.supportportalbackend.exception.domain;

/**
 * Exception for email
 *
 * @author Andre Gallegos
 * @create 2022-09-29 11:30
 **/
public class EmailNotFoundException extends Exception {

    public EmailNotFoundException(String message) {
        super(message);
    }
}

