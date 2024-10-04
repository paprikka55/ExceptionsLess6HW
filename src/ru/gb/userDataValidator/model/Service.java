package ru.gb.userDataValidator.model;

import ru.gb.userDataValidator.model.userDataCollector.UserDataCollector;
import ru.gb.userDataValidator.model.writer.FileHandler;
import java.io.IOException;

public class Service {
    private final Validator validator;

    public Service() {
        this.validator = new Validator();
    }

    public boolean startValidator(String inputString) throws RuntimeException, IOException {
        if(validator.initValidate(inputString)){
            return writeToFile(validator.getUserData());
        }
        return false;
    }

    private boolean writeToFile(UserDataCollector userData) throws IOException{
        FileHandler writer = new FileHandler(userData.getLastName() + ".txt");
        return writer.write(userData);
    }

    public UserDataCollector getUserData(){
        return validator.getUserData();
    }
}
