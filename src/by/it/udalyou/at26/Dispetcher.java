package by.it.udalyou.at26;

 class Dispetcher {
    static final int K_SPEED=200;
   private static final int PLAN=100;

     private static volatile int buyerInShop=0;
    private static volatile int buyerCounter=0;

    synchronized static boolean marketClosed(){
        return buyerCounter>=PLAN&&buyerInShop==0;
    }
    synchronized static boolean marketOpend(){
        return buyerCounter<PLAN;
}
    synchronized static int buyerIn (){
        buyerInShop++;
        buyerCounter++;
        return buyerCounter;
    }
   synchronized static void buyerOut(){
     buyerInShop--;
    }

      static void reset(){
          buyerInShop=0;
         buyerCounter=0;

     }
}
