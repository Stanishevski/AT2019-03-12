package by.it._tasks_.at05;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {

        String regex = "[^аАеЕЁёиИоОуУЭэюЮяЯ]+[аАеЕЁёиИоОуУЭэюЮяЯ] ";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            System.out.println(matcher.group());


        }

    }
}