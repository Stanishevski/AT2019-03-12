package by.it.tsyhanova.at27;

public class Cashier implements Runnable {

    private String name;

    public Cashier(long id) {
        this.name = "\t\tCashier № " + id + " ";
    }

    @Override
    public void run() {
        System.out.println(this+" opened");
            while (!Dispatcher.marketClosed()){
                Buyer buyer = QueueBuyers.extract();
                if (buyer!=null){
                    System.out.println(this+" started sevice of "+buyer);
                    Util.sleep(Util.random(2000,5000));
                    synchronized (buyer){
                        //перед отправкой notify покупателю, ему над сообщить, что он уже не ждет, задав значение false сеттером
                        buyer.setWaiting(false);
                        buyer.notifyAll();//кассир сообщает покупателю - notify отвечает за запуск потока
                    }
                    System.out.println(this+" stoped sevice of "+buyer);
                }
            }
        System.out.println(this+" closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
