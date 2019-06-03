package by.it.romanova.at26;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 2 ; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }


        while (Dispatcher.marketOpened()) {
            int count = Util.random(2);
            for (int i = 0; i < count; i++) {
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(Dispatcher.buyerIn());
                    threads.add(buyer);
                    buyer.start();
                }
            }
        }

            for (Thread thread : threads) {
                thread.join();
            }



        System.out.println("Market closed");

    }


}

