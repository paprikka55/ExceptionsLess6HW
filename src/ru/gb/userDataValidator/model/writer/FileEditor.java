package ru.gb.userDataValidator.model.writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileEditor {
    private final String path;

    public FileEditor(String path) {
        this.path = path;
    }

    public boolean editFile(String userData) throws IOException{
        List<String> fileData = new LinkedList<>();
        boolean duplicate = false;
        try(FileReader fr = new FileReader(path); Scanner sc = new Scanner(fr)){
            while (sc.hasNextLine()){
                fileData.add(sc.nextLine());
            }
        }
        for(String fileUserData: fileData){
            if (fileUserData.equals(userData)) {
                duplicate = true;
                break;
            }
        }
        if(!duplicate){
            fileData.add(userData);
            return reWriteFile(fileData);
        }
        return true;
    }

    private boolean reWriteFile(List<String> fileData) throws IOException{
        try(FileWriter fr = new FileWriter(path)){
            for(String fileUserData: fileData){
                fr.write(fileUserData + "\n");
            }
        }
        return true;
    }

}
