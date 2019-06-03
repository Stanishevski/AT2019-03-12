package by.it.tsyhanova.at27;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class QueueBuyers {

    private QueueBuyers() {
    }

    //синхронизацию убрали с помощью новой очереди (раньше был дек)
    static void add(Buyer buyer) {
        QUEUE.addLast(buyer);
    }
    private static final BlockingDeque<Buyer> QUEUE = new LinkedBlockingDeque<>(30);

    static Buyer extract() {
        try {
            return QUEUE.pollFirst(10, TimeUnit.MILLISECONDS);//ожидание своей очереди
            //как только кто-то появится в очереди, его получат
            //если не появится, вернется null, но таймаут теперь не зашит жестко в ожидание
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }


}
