import java.util.ArrayList;

public class Cashier extends Thread{
    private int id;
    private static int nextID = 1;
    boolean openForCustomer;
    long checkOutTime;
    int numOfShoppersChecked;
    ArrayList<Customer> customersSeen;
    long timeSlice;

    public Cashier(long timeSlice) {
        id = nextID;
        nextID++;
        checkOutTime = timeSlice + System.currentTimeMillis();
        openForCustomer = true;
        customersSeen = new ArrayList<>();
    }

    @Override
    public void run() {

            customersSeen.add(Main.queue.poll());
            openForCustomer = false;
            System.out.println("CASHIER: Added Customer " + customersSeen.get(customersSeen.size() - 1).getCustomerId() + " to cashier " + id);
            Main.PrintQueue();

        while(!openForCustomer) {//has customer
            if (checkOutTime < System.currentTimeMillis()) {
            }
            System.out.println("CASHIER: Customer " + customersSeen.get(customersSeen.size()-1).getCustomerId() + " done checking out");//current id of customer
            Main.cashiers.add(this);
            Main.PrintCashiers();
            checkOutTime = System.currentTimeMillis() + timeSlice;
            openForCustomer = true;
        }
    }

    public long getCashierId() {
        return this.id;
    }
}
