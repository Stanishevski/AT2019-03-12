package by.it.udalyou.at11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TaskA {

 //   private static String dir(Class<?> cl){
 //       String path=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
 //       String clDir=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
 //       return path+clDir;
 //         }то же, что и ниже но подробнее

    public static void main(String[] args) {
       String dir=System.getProperty("user.dir")+"/src/by/it/udalyou/at11/";
        List<Integer> list=new ArrayList<>();
writeIn(dir);//Формирование масива 20 случайных чисел и занасение его в Bin
readInt(dir,list);//Чтение масива из Bin и занесение его в list
writeInt(dir,list);//Вывод list на экран и в Txt и подсчет среднего
}
private static void writeIn(String dir){
        try (
        FileOutputStream fos=new FileOutputStream(dir+"dataTaskA.bin");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        DataOutputStream dos=new DataOutputStream(bos);)
{
    for (int i=0; i<20;i++) {
        int value=(int)(Math.random()*100);
        dos.writeInt(value);

    }

}catch (IOException e){
    e.printStackTrace();
}}
 private static void readInt(String dir,List<Integer> list) {
     try (
             FileInputStream fis = new FileInputStream(dir + "dataTaskA.bin");
             BufferedInputStream bis = new BufferedInputStream(fis);
             DataInputStream dis = new DataInputStream(bis)) {
         while (dis.available() > 0) {
             list.add(dis.readInt());
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
private static void writeInt(String dir, List<Integer> list) {
    try (FileWriter fw = new FileWriter(dir + "resultTaskA.txt");
         PrintWriter txt = new PrintWriter(fw))  {
        double sum = 0;
        double count = 0;
        for (Integer element : list) {
            System.out.print(element + " ");
            txt.print(element + " ");
            sum = sum + element;
            count++;
        }
        System.out.println("\navg=" + sum / count);//=sum/list.size()
        txt.println("\navg=" + sum / count);


    } catch (IOException e) {
        e.printStackTrace();
    }

}

}