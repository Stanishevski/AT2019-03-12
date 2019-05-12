package by.it.tsyhanova.at17_samples;

import java.util.Random;

public class RandomExample {

    private static Random generator=new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            int j=generator.nextInt(21)-10;
            System.out.print(j+" ");
        }
    }


}
