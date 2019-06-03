package by.it.tsyhanova.at26;

import java.util.Deque;
import java.util.LinkedList;

class QueueBuyers {

    private QueueBuyers() {
    }

    private static final Deque<Buyer> QUEUE = new LinkedList<>();//очередь дженерализованная баерами, являющаяся листом
    //т.к. LinkList потоконебезопасный, требуется синхронизация
    static void add(Buyer buyer) {//метод добавления покупателя в очередь
        synchronized (QUEUE) {
            QUEUE.addLast(buyer);//используется интерфейс deque
        }
    }

    static Buyer extract() {//метод извелечения покупателя
        synchronized (QUEUE) {
            return QUEUE.pollFirst();
        }

    }


}
