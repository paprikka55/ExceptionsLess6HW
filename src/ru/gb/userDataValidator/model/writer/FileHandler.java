package ru.gb.userDataValidator.model.writer;

import ru.gb.userDataValidator.model.userDataCollector.UserDataCollector;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements Writer{
    private final String path;

    public FileHandler(String filename) {
        this.path = "./SavedData/" + filename;
    }

    @Override
    public boolean write(UserDataCollector userData) throws IOException {
        File file = new File(path);
        if(file.exists()){
            FileEditor fileEditor = new FileEditor(path);
            return fileEditor.editFile(userData.toString());
        }
        try(FileWriter fr = new FileWriter(path)){
            fr.write(userData.toString() + "\n");
        }
        return true;
    }
}
