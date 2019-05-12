package by.it.tsyhanova;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {


    public static void main(String[] args) {
        String filename=System.getProperty("user.dir")+
                "/src/main/java/by/it/tsyhanova/vars.txt";

        //System.out.println(System.getProperty("user.dir"));

        Parser parser=new Parser();
        Printer printer=new Printer();
        Scanner scanner=new Scanner(System.in);

        Var.loadFromFile();

        StringBuilder sb=new StringBuilder();
        try (FileReader reader = new FileReader(filename)) {
            // читаем посимвольно и сохраняем в StringBuffer
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char)c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        for(;;){
            String expression=scanner.nextLine();
            if (expression.equals("end")) {
                Var.saveToFile();
                break;
            }
            else if(expression.equals("printvar")){
                System.out.println(sb.toString());
                break;
            }

            Var var = null;
            try {
                var = parser.calc(expression);
            } catch (CalcException e) {
                System.out.println("Ошибка в "+expression);
                System.out.println(e.getMessage());
            }
            printer.print(var);
        }
    }
}
