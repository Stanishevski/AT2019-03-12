package by.it.udalyou.at26;

import java.util.LinkedList;
import java.util.Deque;

 class QueueBuyers {

    private QueueBuyers() {

    }

    private static final  Deque<Buyer> QUEUE =new LinkedList<>();

   static void add (Buyer buyer){
        synchronized (QUEUE){
        QUEUE.addLast(buyer);
        }
    }
   static Buyer extract(){
        synchronized (QUEUE){
        return QUEUE.pollFirst();
        }
    }

}
