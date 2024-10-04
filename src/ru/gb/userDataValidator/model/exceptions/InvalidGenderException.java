package ru.gb.userDataValidator.model.exceptions;

public class InvalidGenderException extends RuntimeException{
    public InvalidGenderException() {
        super("Некорректные данные в поле пол! Должен быть один символ \"f\" или \"m\"!");
    }
}
