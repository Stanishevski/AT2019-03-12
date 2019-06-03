package by.it.tsyhanova.at27;

public class Buyer extends Thread implements IBuyer {

    private boolean waiting = false;//приватное поле ожидания

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }//сеттер

    Buyer(long number) {
        super("Buyer № " + number + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        addToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to the Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Util.random(500, 2000);
        System.out.println(this + "wait " + timeout + " seconds");
        Util.sleep(timeout);
        System.out.println(this + "finished to choose goods");
    }
    //потоком управлять невозможно
    //его можно только запустить, как public static void main
    @Override
    public void addToQueue() {
        QueueBuyers.add(this);
        //ожидаем
        synchronized (this) {
            waiting = true;
            //пока ожидание является истиной, покупатель будет засыпать
            while (waiting) {
                try {
                    this.wait();//баер ждет пока кассир совершает ему notify в своем классе
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);//аварийное закрытие потока с помощью непроверяемого исключения
                    //чтобы поток остановила сама джава-машина
                }
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "out from the Market");
        Dispatcher.buyerOut();
    }

    @Override
    public String toString() {
        return getName();
    }
}
