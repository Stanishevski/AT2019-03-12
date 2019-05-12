package by.it.simanovich.at11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static final String PUNCTUATION_REGEXP = "[.,:!?\\-]+";
    private static final String ALPHABETIC_REGEXP = "([А-Яа-яёЁ]+)";

    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"/src/by/it/simanovich/at11/";
        File f = new File(path+"TaskB.txt") ;

        int numWords = 0;
        int numPunct = 0;
        try(FileReader fr = new FileReader(f);
            Scanner scan = new Scanner(fr))
        {
            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                List<String> wordsArray = splitByExpression(str, true);
                List<String> punctArray = splitByExpression(str, false);
                numWords += wordsArray.size();
                numPunct += punctArray.size();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printNumberOfWordsAndChars(path, numWords, numPunct);
    }

    private static void printNumberOfWordsAndChars(String path, int numWords, int numPunct) {
        try (FileWriter fw=new FileWriter(path+"resultTaskB.txt");
             PrintWriter pw=new PrintWriter(fw))
        {
            System.out.println("words=" + numWords + ", punctuation marks=" + numPunct);
            pw.print("words=" + numWords + ", punctuation marks=" + numPunct);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> splitByExpression(String str, boolean isAlphabetic) {
        Pattern pattern = Pattern.compile(isAlphabetic ? ALPHABETIC_REGEXP : PUNCTUATION_REGEXP);
        Matcher matcher = pattern.matcher(str);
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(isAlphabetic ? matcher.group(1) : matcher.group());
        }
        return result;
    }
}