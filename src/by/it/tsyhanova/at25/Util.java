package by.it.tsyhanova.at25;

import java.util.Random;

class Util {

    private static Random rnd=new Random();

    private Util() {
    }

    static int random(int start, int stop) {
        int delta=(stop - start);
        return rnd.nextInt(delta)+start;
    }

    static int random(int max) {
        return random(0, max);
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);//при разгоне примерно в 100 раз
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
