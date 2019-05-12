package by.it.simanovich.at11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String path=System.getProperty("user.dir")+ "/src/by/it/simanovich/at11/";
        writeInt(path);

        List<Integer> list=new ArrayList<>();
        readInt(path, list);
        printInt(path, list);
    }

    private static void printInt(String path, List<Integer> list) {
        try (FileWriter fw=new FileWriter(path+"resultTaskA.txt");
             PrintWriter txt=new PrintWriter(fw))
        {
            double sum=0;
            for (Integer element : list) {
                System.out.print(element+" ");
                txt.print(element+" ");
                sum=sum+element;
            }
            System.out.println("\navg="+sum/list.size());
            txt.println("\navg="+sum/list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readInt(String path, List<Integer> list) {
        try (FileInputStream fis=new FileInputStream(path+"dataTaskA.bin");
             BufferedInputStream bis=new BufferedInputStream(fis);
             DataInputStream dis=new DataInputStream(bis)
        ){
            while (dis.available()>0){
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeInt(String path) {
        try (FileOutputStream fos=new FileOutputStream(path+"dataTaskA.bin");
             BufferedOutputStream bos=new BufferedOutputStream(fos);
             DataOutputStream dos=new DataOutputStream(bos);
        )
        {
            for (int i = 0; i < 20; i++) {
                int value=(int)(Math.random()*100);
                dos.writeInt(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
