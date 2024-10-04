package ru.gb.userDataValidator.model;

import ru.gb.userDataValidator.model.userDataCollector.UserDataCollector;
import ru.gb.userDataValidator.model.userDataCollector.UserDataCollectorItems;


public class Validator {

    private final InspectorsInitiator inspectorsInitiator;
    private UserDataCollector userDataCollector;


    public Validator() {
        this.inspectorsInitiator = new InspectorsInitiator();
    }

    public boolean initValidate(String validatedData) throws RuntimeException{
        boolean validateData = true;
        String[] userData = inspectorsInitiator.verifiedAndGetStringFormat(validatedData);
        inspectorsInitiator.validateItem(UserDataCollectorItems.LastName, userData[0]);
        inspectorsInitiator.validateItem(UserDataCollectorItems.FirstName, userData[1]);
        inspectorsInitiator.validateItem(UserDataCollectorItems.Patronymic, userData[2]);
        inspectorsInitiator.validateItem(UserDataCollectorItems.BirthDate, userData[3]);
        inspectorsInitiator.validateItem(UserDataCollectorItems.PhoneNumber, userData[4]);
        validateData = inspectorsInitiator.validateItem(UserDataCollectorItems.Gender, userData[5]);
        if(validateData){
            userDataCollector = new UserDataCollector(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5]);
        } else {
            userDataCollector = null;
            return false;
        }
        return true;
    }
    public UserDataCollector getUserData(){
        return userDataCollector;
    }
}
