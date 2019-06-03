package by.it.romanova.at09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 25; i++) {
            int grade = (int)(Math.random()*10)+1;
            task.list.add((int)Math.ceil(Math.random()*10));
        }
        System.out.println(task.list);
     //   task.clearBad(task.list);
        System.out.println(task.list);
    }
//
//    private void clearBad(List<Integer> grades){
//        grades.removeIf(grade -> grade < 4);
//
//
//
//    }
}
