package ru.gb.userDataValidator.presenter;

import ru.gb.userDataValidator.model.Service;
import ru.gb.userDataValidator.view.Ui;

import java.io.IOException;

public class Presenter {
    private final Service service;
    private final Ui ui;

    public Presenter(Ui ui) {
        this.ui = ui;
        this.service = new Service();
    }

    public void validateData(String stringUserData) {
        try{
            service.startValidator(stringUserData);
            ui.printAnswer("Данные внесены в файл: " + service.getUserData().getLastName() + ".txt");
        } catch (IOException exception){
            String error = "Ошибка!: \n" +
                    exception.getClass().getName() +
                    ": " +
                    exception.getMessage();
            ui.printError(error);
        } catch (RuntimeException exception){
            String error = "Ошибка ввода данных!: \n" +
                    exception.getClass().getName() +
                    ": \n" +
                    exception.getMessage();
            ui.printError(error);
        } finally {
            ui.askAgain();
        }
    }
}
