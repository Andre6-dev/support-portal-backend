package com.devandre.supportportalbackend.exception.domain;

/**
 * Exception when the email has been encountered
 *
 * @author Andre Gallegos
 * @create 2022-09-29 11:39
 **/
public class EmailExistException extends Exception {

    public EmailExistException(String message) {
        super(message);
    }
}
