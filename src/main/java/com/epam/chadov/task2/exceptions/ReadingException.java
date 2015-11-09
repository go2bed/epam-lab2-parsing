package com.epam.chadov.task2.exceptions;


public class ReadingException extends Exception {
    public ReadingException(String message) {
        super(message);
    }
    public ReadingException(String message, Throwable cause){
        super(message, cause);
    }
}
