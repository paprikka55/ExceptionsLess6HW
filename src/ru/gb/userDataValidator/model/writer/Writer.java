package ru.gb.userDataValidator.model.writer;

import ru.gb.userDataValidator.model.userDataCollector.UserDataCollector;

import java.io.IOException;

public interface Writer {
    boolean write(UserDataCollector userData) throws IOException;
}
