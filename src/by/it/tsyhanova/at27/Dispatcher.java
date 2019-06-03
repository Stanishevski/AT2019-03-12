package by.it.tsyhanova.at27;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED = 5000;

    private static final int PLAN = 100;
    private static final AtomicInteger buyerInShop=new AtomicInteger(0);//счетчик атомик  интеджер, который никогда не поменяется
    //поэтому атомик счетчик делают final
    //сам объект уже никогда не изменится
    //но его значение можно уменьшать и увеличивать
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);

    static boolean marketClosed() {
        return buyerCounter.get() >= PLAN &&//т.к. атомик-счетчик - это объект, изменение его значения идет через метод get()
                buyerInShop.get() == 0;
    }

    static boolean marketOpened(){
        return buyerCounter.get()<PLAN;
    }

    static int buyerIn(){
        buyerCounter.getAndIncrement();//увеливение значения счетчика
        buyerInShop.getAndIncrement();
        return buyerCounter.get();
    }

    static void buyerOut(){
        buyerInShop.getAndDecrement();
    }

    static void reset() {
        buyerInShop.set(0);
        buyerCounter.set(0);
    }
}
