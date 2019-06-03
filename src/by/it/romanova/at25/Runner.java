package by.it.romanova.at25;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        List<Buyer> buyers = new ArrayList<>();
        int count = Util.random(2);
        for (int i = 0; i < count; i++) {
           // Util.sleep(1000);
            Buyer buyer = new Buyer(++Dispatcher.buyerCounter);
            buyers.add(buyer);
            buyer.start();
        }

        for (Buyer buyer : buyers) {
            buyer.join();
        }


        System.out.println("Market closed");

    }


}

