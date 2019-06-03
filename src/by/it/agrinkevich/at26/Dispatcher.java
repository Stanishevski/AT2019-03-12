package by.it.agrinkevich.at26;

class Dispatcher {
    static final int K_SPEED = 5000;

    private static volatile int buyerCounter = 0;
    private static volatile int buyerInShop = 0;
    private static final int PLAN = 100;

    static synchronized boolean marketIsClosed() {
        return buyerCounter >= PLAN &&
                buyerInShop == 0;
    }

    static synchronized boolean marketOpened() {
        return buyerCounter < PLAN;
    }

    static synchronized int buyerIn() {
        buyerCounter++;
        buyerInShop++;
        return buyerCounter;
    }

    static synchronized void buyerOut() {
        buyerInShop--;
    }

    static synchronized void reset() {
        buyerInShop = 0;
        buyerCounter = 0;
    }
}
