package com.example.demo;

public class UserEntityNotFoundException extends RuntimeException {
    UserEntityNotFoundException(Integer id) {
        super("Не могу найти пользователя с id " + id);
    }
}
