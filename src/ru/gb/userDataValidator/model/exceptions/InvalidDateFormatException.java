package ru.gb.userDataValidator.model.exceptions;

public class InvalidDateFormatException extends RuntimeException{
    public InvalidDateFormatException() {
        super("Неверный формат даты! Дата должна быть формата: dd.mm.yyyy!");
    }
}
