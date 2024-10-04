package ru.gb.userDataValidator.model.exceptions;

public class InvalidPhoneNumberFormatException extends RuntimeException{
    public InvalidPhoneNumberFormatException() {
        super("Неверный формат номера телефона!");
    }
}
