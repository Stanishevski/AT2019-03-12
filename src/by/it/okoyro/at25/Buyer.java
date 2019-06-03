package by.it.okoyro.at25;

public class Buyer extends Thread implements IBuyer {

	@Override
	public void run() {
		enterTheShop();
		chooseGoods();
		goOut();
	}

	public Buyer(long number) {
		super("Buyer #" + number + " ");
	}

	@Override
	public void enterTheShop() {
		System.out.println(this + "gets in to the Shop");
	}

	@Override
	public void chooseGoods() {
		System.out.println(this + "starts to choose goods");
		int timeout = Util.random(500, 2000);
		System.out.println(this + "waits for " + timeout + " seconds");
		Util.sleep(timeout);
		System.out.println(this + "finishes to choose goods");

	}

	@Override
	public void goOut() {
		System.out.println(this + "gets out of the Shop");
		Dispatcher.buyerCounter--; // один счетчик для всех потоков покупателей - источник проблемы, существует вероятность
		// что счетчик посчитает 2 покупателей как 1 (в случае совпадения работы 2 потоков)

	}

	@Override
	public String toString() {
		return getName(); // метод из Thread, вернет имя, которое мы передаем в конструкторе выше (для удобства печати)
	}
}
