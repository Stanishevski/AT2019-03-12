package by.it.udalyou.at12;

import java.io.*;

public class TaskB {
    public static void main(String[] args) throws IOException {
/*В программе создайте хотя бы 5 разных комментариев: 2 однострочных,
 2 многострочныхи 1 JavaDoc

Программа должна прочитать свой собственный текст в переменную типа
    StringBuilder.***/

//Читая программу необходимо удалить все возможные виды комментариев,
  /*  не трогая остальное. /
Результат вывести на консоль и в файл с тем же местоположением и именем,
    но с расширением txt,а не java.
Считайте, что комментарии внутри строки невозможны
         Регулярные выражения использовать нельзя  */

        FileReader fileReader=new FileReader(System.getProperty(//"E:\\udalyou\\" +
               // "AT2019-03-12-33\\src\\by\\it\\udalyou\\at12\\TaskB.java)"));
                "user.dir")+"/src/by/it/udalyou/at12/TaskB.java");
        StringBuilder stringBuilder=new StringBuilder();
        String filename=System.getProperty("user.dir")+
                "/src/by/it/udalyou/at12/TaskB.txt";
        //Определяем к какой фазе программы относится символ
        Mode mode=Mode.CODE;
        while (fileReader.ready()){
            char ch=(char) fileReader.read();
            // проверка чтения
           // System.out.print(ch);
            switch (mode){
                case CODE:
                    if (ch=='/'){
                        mode=Mode.STARTCOMMENT;
                        break;
                         }
                    else {stringBuilder.append(ch);
                    break;}
                case STARTCOMMENT:
                    if (ch=='*'){
                        mode=Mode.MULTILINE;
                        break;
                    }else if (ch=='/'){
                        mode=Mode.ONELINE;
                        break;
                        }else {
                        stringBuilder.append('/');
                        mode=Mode.CODE;
                        break;
                    }
                case ONELINE:
                    if(ch=='\n'){
                        stringBuilder.append('\n');
                        mode=Mode.CODE;
                        break;
                    }
                case MULTILINE:
                    if (ch=='*'){
                        mode=Mode.ENDCOMMENT;
                        break;
                    }else break;
                case ENDCOMMENT:
                    if (ch=='/'){
                        mode=Mode.CODE;
                        break;
                    } else{
                        mode=Mode.MULTILINE;
                   break;
                    }
            }
        }
        System.out.println(stringBuilder);
        PrintWriter pw=new PrintWriter(new FileWriter(filename));
        pw.print(stringBuilder);
    }
}
