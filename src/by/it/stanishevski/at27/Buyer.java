package by.it.stanishevski.at27;

public class Buyer extends Thread implements IBuyer {

    private  boolean waiting = false;

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    Buyer (long number) {super("Buyer № "+ number );}

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        addToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start to choose goods");
        int timeout = Util.random(500, 2000);
        System.out.println(this + " wait "+ timeout+ " seconds");
        Util.sleep(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void addToQueue() {
    QueueBuyers.add(this);
    waiting = true;
    while (waiting) {
         synchronized (this) {
             try {
            this.wait();
                 } catch (InterruptedException e) {
            e.printStackTrace();
    }
    }
    }
    }

    @Override
    public void goOut() {
        System.out.println(this + " out from Market");
        Dispatcher.buyerOut();
        //Dispatcher.buyerCounter--;

    }

    @Override
    public String toString() {
        return getName();
    }
}
