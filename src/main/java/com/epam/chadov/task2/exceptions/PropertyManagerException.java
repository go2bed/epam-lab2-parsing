package com.epam.chadov.task2.exceptions;


public class PropertyManagerException extends Exception {
    public PropertyManagerException(String message){
        super(message);
    }
    public PropertyManagerException(String message, Throwable cause){
        super(message, cause);
    }
}
