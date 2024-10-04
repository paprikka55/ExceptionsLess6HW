package ru.gb.userDataValidator.model.exceptions;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException(String date) {
        super("Некорректная дата: " + date);
    }
}
