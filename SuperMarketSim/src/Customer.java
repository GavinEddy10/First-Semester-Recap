import java.util.concurrent.ConcurrentLinkedQueue;

public class Customer extends Thread{//queue goes in here, add
    private int id;
    private static int nextID = 1;
    private long shopTime;  //how long ms cus shops for
    private long checkOutTime;   //how many ms cus takes to check out
    private long enterTime;   //time cus entered store
    private long leaveTime;   //time cus leaves store after checkout and seeing casheir
    private long minShopTime = 3000; //min time ms cucs shops
    private long maxShopTime = 20000; //max time ms cus shops
    private long enterQueueTime;

    public Customer() {
        id = nextID;
        nextID++;
        enterTime = System.currentTimeMillis();
        shopTime = (long)(minShopTime + Math.random()* (maxShopTime-minShopTime));
        checkOutTime = 2000;
    }

    @Override
    public String toString() {
        return "Customer " + id;
    }

    @Override//adding override helps know it exists above you
    public void run() {
        while(enterTime + shopTime > System.currentTimeMillis()) {
        }
        System.out.println(this.toString() + " is done shopping with shop time " + shopTime);//customer done shopping

        //adding to queue, setting queue time entere, printing queue to check it
        Main.queue.add(this);
        enterQueueTime = System.currentTimeMillis();
        Main.PrintQueue();

        //cashiers
        if (Main.cashiers.size() > 0) {
            Main.cashiers.get(Main.cashiers.size()-1).start();//start last cashier in arraylist, take in this customer//don't need made method in main
            Main.cashiers.remove(Main.cashiers.size()-1);//remove cashier from list of cashiers
        }
    }

    public long getEnterQueueTime() {
        return enterQueueTime;
    }


    public int getCustomerId() {
        return id;
    }
}
