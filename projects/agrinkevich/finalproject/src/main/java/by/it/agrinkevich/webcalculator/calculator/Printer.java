package by.it.agrinkevich.webcalculator.calculator;

public class Printer {
    void print(Var var) {
        if (var != null) {
            System.out.println(var);
            Logger.writeToLog("INFO: " + var);
        }
    }
}
