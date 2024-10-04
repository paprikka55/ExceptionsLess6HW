package ru.gb.userDataValidator.model.inspectors;

import ru.gb.userDataValidator.model.exceptions.IllegalCharsInData;

import java.util.regex.Pattern;

public class FirstLastPatronymicItemInspector implements ItemInspector {

    @Override
    public boolean inspectItem(String verifiableData) {
        if(!Pattern.matches("[а-яА-Яa-zA-Z]+", verifiableData)){
            throw new IllegalCharsInData(verifiableData);
        }
        return true;
    }


}
