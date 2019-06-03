package by.it.okoyro.at26;

class Dispatcher {

	static final int K_SPEED = 100; // is used to increase speed

	private static final int PLAN = 100;

	private static volatile int totalBuyersCounter = 0;
	private static volatile int buyersInShop = 0;

	synchronized static boolean isShopReadyToClose() {
		return totalBuyersCounter >= PLAN &&
			   buyersInShop == 0;
	}

	synchronized static boolean isShopOpened() {
		return totalBuyersCounter < PLAN;
	}

	synchronized static int buyerIn() {   // method has to be
		totalBuyersCounter++;
		buyersInShop++;
		return totalBuyersCounter;
	}

	synchronized static void buyerOut() {
		buyersInShop--;
	}
}
