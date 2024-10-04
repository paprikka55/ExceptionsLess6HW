package ru.gb.userDataValidator.model.inspectors;

import ru.gb.userDataValidator.model.exceptions.InvalidPhoneNumberFormatException;

import java.util.regex.Pattern;

public class PhoneNumberItemInspector implements ItemInspector {
    @Override
    public boolean inspectItem(String verifiableData) {
        if(!Pattern.matches("^\\+?\\d{1}[-.]?(\\(?\\d{3}\\)?)[-.]?\\d{3}[-.]?\\d{2}[-.]?\\d{2}$", verifiableData)){
            throw new InvalidPhoneNumberFormatException();
        }
        return true;
    }
}
