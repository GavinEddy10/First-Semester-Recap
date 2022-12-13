import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomerFactory extends Thread{
    private long timeSlice;
    private long chance;
    private long nextAttempt;
    private ArrayList<Customer> customers;

    public CustomerFactory(long timeSlice, long chance, ArrayList<Customer> customers) {
        this.timeSlice = timeSlice;
        this.chance = chance;
        nextAttempt = System.currentTimeMillis() + this.timeSlice;
        this.customers = customers;
    }


    @Override
    public void run() {
        while (true) {
            if (nextAttempt < System.currentTimeMillis()) {//current time in ms
                long randomNum = (long) (1 + Math.random() * 100);
                if (randomNum <= chance) {//random num 1-100, if random num is less than chance, customer made
                    System.out.println("Made customer");
                    Customer c = new Customer();
                    customers.add(c);
                    c.start();//starts customer thread
                }
                else {
                    System.out.println("Did not make customer");
                }
                nextAttempt = System.currentTimeMillis() + timeSlice;
            }
        }
    }

    public void printCustomersList() {
        System.out.print("Customer List: ");
        for (Customer c: customers) {
            System.out.print(c + ", ");
        }
        System.out.println();
    }
}
