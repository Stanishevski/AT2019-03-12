package by.it.tsyhanova.at17_samples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SampleReadTxt {
    public static void main(String[] args) {
        String fileName="src/by/it/tsyhanova/at11/text.txt";
        try (
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader=new BufferedReader(fileReader)
        ){
            //Imperative loop
            for(;;){
                String line = bufferedReader.readLine();
                if (line==null) break;
                System.out.println(line);
            }

            //Functional styleImperative loop
            bufferedReader.lines()
                    .skip(2)
                    .sorted((o1,o2)->-o1.length()+o2.length())
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}
