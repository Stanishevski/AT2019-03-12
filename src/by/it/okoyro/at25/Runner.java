package by.it.okoyro.at25;

import java.util.ArrayList;
import java.util.List;

public class Runner {
	public static void main(String[] args) {

		List<Buyer> buyers = new ArrayList<>(); // list to store buyers

		System.out.println("Shop is opened");

		for (int time = 0; time < 120; time++) {  // set 120 seconds
			Util.sleep(1000);
			int count = Util.random(2); // set max quantity of buyers in thread
			for (int i = 0; i <= count; i++) {
				Buyer buyer = new Buyer(++Dispatcher.buyerCounter); // create buyer  & increase buyers quantity
				buyers.add(buyer);  // add buyer to list
				buyer.start();
			}
		}
		for (Buyer buyer : buyers) {
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
