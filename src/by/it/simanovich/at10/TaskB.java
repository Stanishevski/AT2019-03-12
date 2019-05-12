package by.it.simanovich.at10;

import java.util.Scanner;

public class TaskB {

    private static void printInfoException(RuntimeException e) {
        String name = e.getClass().getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String myClassName = element.getClassName();
            int lineNumber = element.getLineNumber();
            if (myClassName.equals(TaskB.class.getName())) {
                System.out.printf("" +
                                " name: %s\n" +
                                "class: %s\n" +
                                " line: %d\n",
                        name, myClassName, lineNumber
                );
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String txt = scanner.nextLine();
            if (txt.equals("END"))
                break;
            try {
                double value = Double.parseDouble(txt);
                System.out.println(value);
                //todo допилить
            } catch (NumberFormatException e) {
                printInfoException(e);
            }
        }
    }
}
