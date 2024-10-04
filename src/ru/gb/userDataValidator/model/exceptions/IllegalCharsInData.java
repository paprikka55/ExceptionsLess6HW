package ru.gb.userDataValidator.model.exceptions;

public class IllegalCharsInData extends RuntimeException{
    public IllegalCharsInData(String data) {
        super("Некорректные символы в строке: " + "\"" + data + "\"");
    }
}
