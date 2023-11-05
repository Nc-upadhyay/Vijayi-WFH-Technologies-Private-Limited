package com.nc.postgresql_crud.exception;

public class UserNotFound extends RuntimeException {
    String message;

    public UserNotFound() {
        message = "user Not found";
    }

    public UserNotFound(String message) {
        super(message);
    }
}
