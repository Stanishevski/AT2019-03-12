package by.it.romanova;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        for(;;){
            String expression = sc.nextLine();
            if(expression.equals("end"))
                break;
            Var var;
            try {
                if(expression.contains("(") && expression.contains(")")){
                    expression = parser.excludeBraces(expression);
                }
                    var = parser.calc(expression);
                    printer.print(var);
            } catch (CalcException e) {
                System.out.println("Ошибка в " + expression + "\n" + e.getMessage());
            }

        }

    }
}