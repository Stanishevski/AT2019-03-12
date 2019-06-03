package by.it.okoyro.at26;

import java.util.Deque;
import java.util.LinkedList;

class BuyersQueue {

	private BuyersQueue() {}

	private static final Deque<Buyer> QUEUE = new LinkedList<>();

	static void add(Buyer buyer) {
		synchronized (QUEUE) {  // синхронизация на объекте QUEUE который используется в качестве монитора
			QUEUE.addLast(buyer);
		}

	}

	static Buyer extract() {
		synchronized (QUEUE) {
			return QUEUE.pollFirst();
		}
	}
}
