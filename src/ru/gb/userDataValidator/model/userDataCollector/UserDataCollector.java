package ru.gb.userDataValidator.model.userDataCollector;

import java.util.Date;

public class UserDataCollector {
    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private final String birthDate;
    private final String phoneNumber;
    private final String gender;

    public UserDataCollector(String lastName, String firstName, String patronymic, String birthDate, String phoneNumber, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(lastName);
        sb.append(">");
        sb.append("<");
        sb.append(firstName);
        sb.append(">");
        sb.append("<");
        sb.append(patronymic);
        sb.append(">");
        sb.append("<");
        sb.append(birthDate);
        sb.append(">");
        sb.append("<");
        sb.append(phoneNumber);
        sb.append(">");
        sb.append("<");
        sb.append(gender);
        sb.append(">");
        return sb.toString();
    }
}
