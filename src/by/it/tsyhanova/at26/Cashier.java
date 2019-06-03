package by.it.tsyhanova.at26;

public class Cashier implements Runnable {

    private String name;//имя кассира

    public Cashier(long id) {
        this.name = "\t\tCashier № " + id + " ";
    } //конструктор кассира

    @Override
    public void run() {
        System.out.println(this+" opened");//открытие кассы
            while (!Dispatcher.marketClosed()){//пока план не выполнен и магазин не закрылся
                Buyer buyer = QueueBuyers.extract();//извлечение из очереди покупателя
                if (buyer!=null){//если покупатель существует
                    System.out.println(this+" started sevice of "+buyer);//обслуживание покупателя
                    Util.sleep(Util.random(2000,5000));//время обслуживания от 2 до 5 секунд
                    synchronized (buyer){//синхронизируемся на покупателе
                        buyer.notify();//пробуждение покупателя и отправка его в нужное место
                    }
                    System.out.println(this+" stoped sevice of "+buyer);
                }
                else//если покупателя не было, то подождем следующего покупателя в течение 10 милисекунд
                    Util.sleep(10);
            }
        System.out.println(this+" closed");//закрытие кассы
    }

    @Override
    public String toString() {
        return name;
    }
}
