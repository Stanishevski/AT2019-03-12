package by.it.okoyro.at26;

import java.util.ArrayList;
import java.util.List;

public class ShopRunner {
	public static void main(String[] args) {

		List<Thread> combinedThreads = new ArrayList<>(); // list to store all threads (buyers & cashiers)

		for (int j = 1; j <= 2; j++) {
			Cashier cashier = new Cashier(j);
			Thread cashierThread = new Thread(cashier);
			combinedThreads.add(cashierThread);
			cashierThread.start();
		}


		System.out.println("Shop is opened");

		while (Dispatcher.isShopOpened()) {
			Util.sleep(1000);
			int count = Util.random(2); // set max quantity of buyers in one thread
			for (int i = 0; i <= count; i++) {
				if (Dispatcher.isShopOpened()) {
					Buyer buyer = new Buyer(Dispatcher.buyerIn()); // buyerIn method increases total quantity and in shop quantity
					combinedThreads.add(buyer);  // add buyers to threads' list
					buyer.start();
				}
			}
		}
		for (Thread buyer : combinedThreads) {
			try {
				buyer.join();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Shop is closed");  // shop will be closed when last buyer leaved
	}
}
