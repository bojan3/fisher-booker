package com.example.fisherbooker.exception;

public class InvalidTokenException extends Throwable{

    public InvalidTokenException() {
        super();
    }


    public InvalidTokenException(String message) {
        super(message);
    }


    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
