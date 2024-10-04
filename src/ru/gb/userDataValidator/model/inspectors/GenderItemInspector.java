package ru.gb.userDataValidator.model.inspectors;
import ru.gb.userDataValidator.model.exceptions.InvalidGenderException;
import java.util.regex.Pattern;

public class GenderItemInspector implements ItemInspector {
    @Override
    public boolean inspectItem(String verifiableData) {
        if(!Pattern.matches("[fm]", verifiableData)){
            throw new InvalidGenderException();
        }
        return true;
    }
}
