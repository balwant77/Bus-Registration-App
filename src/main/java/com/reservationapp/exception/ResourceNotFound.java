package com.reservationapp.exception;

public class ResourceNotFound extends RuntimeException {
    String message;
    public ResourceNotFound(String message) {
        super(message);
    }
}
