package by.it.tsyhanova.at26;

import java.util.ArrayList;
import java.util.List;

public class Market {//бывший Runner
    public static void main(String[] args) {

        for (int j = 0; j < 1000; j++) {
            Dispatcher.reset();
            List<Thread> threads = new ArrayList<>();//магазин должен закрыться, когда закончатся и покупатели и кассиры


            for (int i = 1; i <= 2; i++) {//цикл ограничен количеством кассиров
                Cashier cashier = new Cashier(i);//создание кассира
                Thread thread = new Thread(cashier);//передача в поток кассира
                threads.add(thread);//кассир добавляется в лист тредов-потоков
                thread.start();//запуск кассира
            }

            System.out.println("Market opened");
            while (Dispatcher.marketOpened()) {
                Util.sleep(1000);
                int count = Util.random(2);
                for (int i = 0; i <= count; i++) {
                    if (Dispatcher.marketOpened()) {//отрабатывает, если магазин еще открыт
                        //дополнительная проверка, чтобы не получился 101 покупатель
                        //если в строке int count = Util.random(2); случайно выпадет 2
                        Buyer buyer = new Buyer(Dispatcher.buyerIn());
                        threads.add(buyer);//покупатель добавляется в лист тредов
                        buyer.start();//запуск кассиров
                    }
                }
            }
            for (Thread buyer : threads) {
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Market close");
        }
    }
}
