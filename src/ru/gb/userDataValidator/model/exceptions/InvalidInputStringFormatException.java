package ru.gb.userDataValidator.model.exceptions;

public class InvalidInputStringFormatException extends RuntimeException{
    public InvalidInputStringFormatException() {
        super("Неверный формат строки! Необходимо ввести строку из шести элементов разделенных пробелами!");
    }
}
