package by.it.agrinkevich.webcalculator.calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {

    private static String filename = System.getProperty("user.dir") + "/src/main/java/by/it/agrinkevich/log.txt";

    static void writeToLog(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.println(message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            errorLog(e.getMessage());
        }
    }

    static void errorLog(String message) {
        writeToLog("ERROR: " + message);
    }
}
