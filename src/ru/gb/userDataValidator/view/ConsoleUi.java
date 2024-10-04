package ru.gb.userDataValidator.view;

import ru.gb.userDataValidator.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUi implements Ui{
    private final Presenter presenter;
    private Scanner sc;

    public ConsoleUi() {
        this.presenter = new Presenter(this);
        this.sc = new Scanner(System.in);
    }

    public boolean yesNoQuestion(String question){
        boolean stopFlag = false;
        boolean result = false;
        while (!stopFlag){
            System.out.print(question + " Y/N?: ");
            String answer = sc.nextLine();
            switch (answer.toLowerCase()){
                case "y" -> {
                    stopFlag = true;
                    result = true;
                }
                case "n" -> {
                    stopFlag = true;
                }
                default -> {
                    System.out.println("Неверный ввод!");
                }
            }
        }
        return result;
    }

    @Override
    public void startUi() {
        System.out.println("Для создания файла с пользовательскими данными введите их ниже!");
        System.out.println("Формат данных: Фамилия Имя Отчество ДатаРождения(dd.mm.yyyy) НомерТелефона пол(символы f/m).");
        System.out.print("Введите данные: ");
        String inputString = sc.nextLine();
        presenter.validateData(inputString);
    }

    private void exitProgram(){
        sc.close();
        System.out.println("Завершение работы...");
        System.exit(0);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    @Override
    public void printError(String error) {
        System.out.println("\u001B[31m" + error + "\u001B[0m");
    }

    @Override
    public void askAgain() {
        if(yesNoQuestion("Повторить ввод?")){
            startUi();
        } else {
            exitProgram();
        }
    }
}
