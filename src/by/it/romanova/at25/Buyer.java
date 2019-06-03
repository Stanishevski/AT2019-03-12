package by.it.romanova.at25;

public class Buyer extends Thread implements IBuyer, IUseBacket{
    Buyer(long number){
        super("Buyer № " + number + " ");
    }


    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + "entered the Market");
    }

    @Override
    public void chooseGoods() {

        System.out.println(this.getName() + "starts choosing goods");

    }

    @Override
    public void goOut() {
        System.out.println(this.getName() + "exit the Market");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBucket();
        chooseGoods();
        putGoodsToBucket();
        goOut();
    }

    @Override
    public void takeBucket() {
        int timeout = Util.random(100,200);
        Util.sleep(timeout);
        System.out.println(this.getName() + "took bucket");
    }

    @Override
    public void putGoodsToBucket() {
        int timeout = Util.random(100,200);
        int goods_count = Util.random(4);
        for (int i = 0; i < goods_count; i++) {
            Util.sleep(timeout);
            Goods goods = new Goods();
            String g = goods.getGood();
            System.out.println(this.getName() + "put good " + g + " in the bucket");
        }
        System.out.println(this.getName() + "stopped choosing goods");

    }
}
