package by.it.romanova.at26;

public class Cashier implements Runnable{

    private String name;

    Cashier(long id) {
        this.name = "\tCashier № " + id;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!Dispatcher.marketClosed()){
            Buyer buyer = Queue.extract();
            if (buyer!=null){
                System.out.println(this +" started service of "+buyer.getName());
                Util.sleep(Util.random(200,500));
                synchronized (buyer){
                    buyer.notify();
                }
                System.out.println(this +" stopped service of "+buyer.getName());
            }
            else
                Util.sleep(10);
        }

        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
