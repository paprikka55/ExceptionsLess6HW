package ru.gb.userDataValidator.model;

import ru.gb.userDataValidator.model.inspectors.*;
import ru.gb.userDataValidator.model.userDataCollector.UserDataCollectorItems;

public class InspectorsInitiator {
    private final VerifiedAndGetStringInspector verifiedAndGetStringInspector;
    private final FirstLastPatronymicItemInspector fioInspector;
    private final BirthdayItemInspector birthdayInspector;
    private final PhoneNumberItemInspector phoneNumberInspector;
    private final GenderItemInspector genderInspector;

    public InspectorsInitiator() {
        this.verifiedAndGetStringInspector = new VerifiedAndGetStringInspector();
        this.fioInspector = new FirstLastPatronymicItemInspector();
        this.birthdayInspector = new BirthdayItemInspector();
        this.phoneNumberInspector = new PhoneNumberItemInspector();
        this.genderInspector = new GenderItemInspector();
    }

    public boolean validateItem(UserDataCollectorItems item, String validatedString) throws RuntimeException{
        boolean result = false;
        switch (item){
            case UserDataCollectorItems.FirstName, UserDataCollectorItems.LastName, UserDataCollectorItems.Patronymic:
                result = fioInspector.inspectItem(validatedString);
                break;
            case UserDataCollectorItems.BirthDate:
                result = birthdayInspector.inspectItem(validatedString);
                break;
            case UserDataCollectorItems.PhoneNumber:
                result = phoneNumberInspector.inspectItem(validatedString);
                break;
            case UserDataCollectorItems.Gender:
                result = genderInspector.inspectItem(validatedString);
                break;
        }
        return result;
    }
    public String[] verifiedAndGetStringFormat(String string) throws RuntimeException{
        return verifiedAndGetStringInspector.verifiedAndGetString(string);
    }
}
