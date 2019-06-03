package by.it.tsyhanova.at27;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {

        Dispatcher.reset();

        //сервис для фиксированного количества потоков
        ExecutorService threadPool= Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);//запуск кассира
            threadPool.execute(cashier);
        }

        threadPool.shutdown();//остановка всех потоков

        System.out.println("Market opened");
        while (Dispatcher.marketOpened()) {
            Util.sleep(1000);
            int count = Util.random(2);
            for (int i = 0; i <= count; i++) {
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(Dispatcher.buyerIn());
                    buyer.start();
                }
            }
        }
        //пока тред потоков не завершен
        while (!threadPool.isTerminated()){//ожидание - стало возможным за счет появления треда потоков
            Util.sleep(10);
        }

        System.out.println("Market close");

    }
}
