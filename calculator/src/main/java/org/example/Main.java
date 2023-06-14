package org.example;

import org.example.Calculate.Calculate;
import org.example.Calculate.PreProcess;
import org.example.Input.Input;
import org.example.Output.Show;
import org.example.Repository.Repository;

import java.util.List;
import java.util.Stack;

public class Main {
    private static int choice;
    public static void main(String[] args) {
        CalConfig calConfig = new CalConfig();
        Calculate calculator = calConfig.calculate();
        Repository repository = calConfig.repository();
        Input input = calConfig.input();
        Show show = calConfig.show();
        PreProcess preProcess = calConfig.preProcess();

        while (true) {
            show.showMenu();
            choice = input.inputChoice();
            System.out.println();
            if (choice == 1) {
                List<String> records = repository.getRecords();
                show.showRecords(records);
            } else {
                String expression = input.inputExpression();
                Stack<String> expressionStack = preProcess.expressionToStack(expression);
                int result = calculator.calculate(expressionStack);
                repository.save(expression,result);
                show.showResult(result);
            }
            System.out.println();
        }
    }
}
