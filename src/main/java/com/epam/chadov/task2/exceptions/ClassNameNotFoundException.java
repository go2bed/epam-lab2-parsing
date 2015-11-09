package com.epam.chadov.task2.exceptions;

public class ClassNameNotFoundException extends Exception {
    public ClassNameNotFoundException(String message){
        super(message);
    }
    public ClassNameNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
