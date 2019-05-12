package by.it.simanovich;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private static String filename = System.getProperty("user.dir") + "/src/by/it/agrinkevich/calc/log.txt";

    public static void writeToLog(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.println(message);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            errorLog(e.getMessage());
        }
    }
    public static void errorLog (String message){
        writeToLog("ERROR: " + message);
    }

        /*try {
            List<String> strings = readTextFile(filename);
            if (strings != null) {
                
            } else {
                strings = new ArrayList<>();
                strings.add(message);

            }
            writeTextFile(strings, filename);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/




    /*static List<String> readTextFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readAllLines(path);
    }

    static void writeTextFile(List<String> strLines, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, strLines);
    }*/
}
