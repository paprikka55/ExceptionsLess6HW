package ru.gb.userDataValidator.model.inspectors;

import ru.gb.userDataValidator.model.exceptions.InvalidInputStringFormatException;

public class VerifiedAndGetStringInspector {

    public String[] verifiedAndGetString(String verifiableData) {
        String[] data = verifiableData.split(" ");
        if (data.length != 6){
            throw new InvalidInputStringFormatException();
        }
        return data;
    }
}
