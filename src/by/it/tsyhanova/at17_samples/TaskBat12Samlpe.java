package by.it.tsyhanova.at17_samples;

import java.io.FileReader;
import java.io.IOException;

public class TaskBat12Samlpe {
    int i;//comment one;
    //comment two;
    int j; /* many lines
    ********************
    * stop */

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(
                System.getProperty("user.dir") +
                        "/src/by/it/tsyhanova/at12/TaskB.java");
        StringBuilder out = new StringBuilder();
        Mode mode = Mode.CODE;
        while (fileReader.ready()) {
            char ch = (char) fileReader.read();
            switch (mode) {
                case CODE:
                    if (ch == '/') {
                        mode = Mode.STARTCOMMENT;
                    } else out.append(ch);
                case STARTCOMMENT:
                    if (ch == '/') {
                        mode = Mode.ONELINE;
                    } else if (ch == '*') {
                        mode = Mode.MULTILINE;
                    } else {
                        out.append('/');
                        mode = Mode.CODE;
                    }
                    //и далее по аналогии
            }
        }

        System.out.println(out);
        //comment end;
    }
}
