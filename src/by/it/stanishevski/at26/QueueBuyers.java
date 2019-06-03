package by.it.stanishevski.at26;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class QueueBuyers {


private static final Deque<Buyer> QUEUE = new LinkedList<>();
static void add (Buyer buyer){
    synchronized (QUEUE) {
        QUEUE.addLast(buyer);
    }
}

static Buyer extract() {
        synchronized (QUEUE){
            return QUEUE.pollFirst();
        }
    }

}
