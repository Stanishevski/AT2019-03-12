package by.it.romanova.at26;

import java.util.Deque;
import java.util.LinkedList;

class Queue {
    private Queue(){

    }
    private static final Deque<Buyer> QUEUE = new LinkedList<>();

    static void addToQueue(Buyer buyer){
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
