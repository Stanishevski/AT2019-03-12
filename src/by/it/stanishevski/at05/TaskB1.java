package by.it.stanishevski.at05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {

        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = p.matcher(Poem.text);
        while (matcher.find()){
            String word=matcher.group();
            if (check(word))
                System.out.println(word);}

    }

    private static final String vowels = "ёуеыаоэяиюЁУЕЫАОЭЯИЮ";

    private static boolean check(String word) {
        boolean first=vowels.indexOf(word.charAt(0))<0;
        boolean last=vowels.indexOf(word.charAt(word.length()-1))>-1;
        return first && last;


    }


}
