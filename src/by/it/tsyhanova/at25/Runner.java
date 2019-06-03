package by.it.tsyhanova.at25;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<Buyer> buyers=new ArrayList<>();//список покупателей, чтобы магазин закрылся после последнего из них

        System.out.println("Market opened");//момент открытия магазина
        for (int time = 0; time < 120; time++) {
            Util.sleep(1000);
            int count=Util.random(2);//заходит 2 человека
            for (int i = 0; i <= count; i++) {
                Buyer buyer=new Buyer(++Dispatcher.buyerCounter);
                buyers.add(buyer);//покупатели собираются в коллекции листа
                buyer.start();
            }
        }
        for (Buyer buyer : buyers) {//перебор всех покупателей коллекции листа
            try {
                buyer.join();//джойним всех покупателей
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Market close");//закроется после выхода всех покупателей
    }
}
