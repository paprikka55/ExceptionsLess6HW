package ru.gb.userDataValidator.model.inspectors;
import ru.gb.userDataValidator.model.exceptions.InvalidDateException;
import ru.gb.userDataValidator.model.exceptions.InvalidDateFormatException;
import java.util.regex.Pattern;

public class BirthdayItemInspector implements ItemInspector {
    @Override
    public boolean inspectItem(String verifiableData) {
        if(!Pattern.matches("\\d{2}\\.\\d{2}\\.\\d{4}", verifiableData)){
            throw new InvalidDateFormatException();
        }
        if (!validateDate(verifiableData.split("\\."))){
            throw new InvalidDateException(verifiableData);
        }
        return true;
    }

    private boolean validateDate(String[] date){
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        if(year < 1 || year > 9999){
            return false;
        }
        if(month < 1 || month > 12){
            return false;
        }
        return day >= 1 && day <= getMaxDayByMonth(month, year);
    }

    private static int getMaxDayByMonth(int month, int year){
        int maxDay = 0;
        switch (month){
            case 1, 3, 5, 7, 8, 10, 12:
                maxDay = 31;
                break;
            case 2:
                if (isLeapYear(year)){
                    maxDay = 29;
                } else {
                    maxDay = 28;
                }
                break;
            default:
                maxDay = 30;
        }
        return maxDay;
    }

    private static boolean isLeapYear(int year){
        return year % 4 == 0;
    }

}
