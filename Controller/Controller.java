package Controller;

import java.util.Scanner;

import Model.DiffCalc;
import Model.DivisionCalc;
import Model.Model;
import Model.MultiCalc;
import Model.SumCalc;
import View.View;

public class Controller {
    public View view;
    private Model model;

    public Controller(View view) {
        this.view = view;
    }

    public void buttonClick() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте число 1");
        double a = view.getValue("a: ");
        System.out.println("Задайте число 2");
        double b = view.getValue("b: ");
        System.out.printf("Вы задали два числа: a = %f и b = %f\n", a, b);
        while (true) {
            System.out.printf("\nВыберите арифметическую операцию для чисел %f и %f: \n", a, b);
            System.out.println("1 - '+' ");
            System.out.println("2 - '-' ");
            System.out.println("3 - '*' ");
            System.out.println("4 - '/' ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.printf("Выбранная операция: сложение\n");
                view.printResult(getResultOfOperation(new SumCalc(), a, b), "Результат сложения: ");
                break;
            } else if (choice == 2) {
                System.out.print("Выбранная операция: вычитание\n");
                view.printResult(getResultOfOperation(new DiffCalc(), a, b), "Результат вычитания: ");
                break;
            } else if (choice == 3) {
                System.out.printf("Выбранная операция: умножение\n");
                view.printResult(getResultOfOperation(new MultiCalc(), a, b), "Результат умножения: ");
                break;
            } else if (choice == 4) {
                System.out.printf("Выбранная операция: деление\n");
                while (true) {
                    if (b == 0) {
                        System.out.println("На 0 делить нельзя\nЗадайте 2-е число");
                        b = view.getValue("b: ");
                        System.out.printf("Вы задали два числа: a: %f и b: %f\nВыбранная операция: деление\n", a, b);
                    } else {
                        break;
                    }
                }
                view.printResult(getResultOfOperation(new DivisionCalc(), a, b), "Результат деления: ");
                break;
            } else {
                System.out.println("Такой операции в списке нет, повторите ввод операции");
            }
        }
        scanner.close();
    }

    private double getResultOfOperation(Model choiceModel, double a, double b) {
        model = choiceModel;
        model.setX(a);
        model.setY(b);
        return model.result();
    }

}
