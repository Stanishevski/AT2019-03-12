package by.it.tsyhanova.at26;

class Dispatcher {

    static final int K_SPEED = 5000;

    private static final int PLAN = 100;//количество покупателей в магазине
    private static volatile int buyerInShop = 0;//счетчик - сколько всего покупателей
    private static volatile int buyerCounter = 0;//счетчик - сколько покупателей вошло в магазин

    //магазин закрыт, если количество покупателей равно или больше плана и общее количество покупателей в магазине == 0
    static synchronized boolean marketClosed() {
        return buyerCounter >= PLAN &&
                buyerInShop == 0;
    }
    //магазин открыт, если покупателей еще меньше плана
    static synchronized boolean marketOpened(){
        return buyerCounter<PLAN;
    }

    static synchronized int buyerIn(){
        buyerCounter++;
        buyerInShop++;
        return buyerCounter;
    }

    static synchronized void buyerOut(){
        buyerInShop--;
    }

    synchronized static void reset() {
        buyerInShop = 0;
        buyerCounter = 0;
    }
}
