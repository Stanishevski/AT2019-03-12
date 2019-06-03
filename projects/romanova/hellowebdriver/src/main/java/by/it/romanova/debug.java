package by.it.romanova;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class debug {

    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        LocalDate date = LocalDate.now().plusDays(1);
        System.out.println(date.format(format));
    }
}
