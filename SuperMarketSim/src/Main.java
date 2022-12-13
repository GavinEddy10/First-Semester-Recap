import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        CustomerFactory customerFactory = new CustomerFactory(5000,50, customers);//time slice is time between each customer
        customerFactory.start();
        Cashier c1 = new Cashier(2000);
        //c1.start();
        cashiers.add(c1);
        startAllCashiers();
    }

    public static ConcurrentLinkedQueue<Customer> queue = new ConcurrentLinkedQueue<>();//peek is 0 index and pull is 0 index and removes it from queue
    public static ArrayList<Cashier> cashiers = new ArrayList<>();
    public static void PrintQueue() {
        System.out.print("QUEUE: ");
        for (Customer c: queue) {
            System.out.print(c + " and enterQueueTime " + c.getEnterQueueTime() + " ms; ");
        }
        System.out.println();
    }

    public static void startAllCashiers() {
        for (Cashier c :cashiers) {
            c.start();
        }
        System.out.println("Started all cashiers.");
    }
    public static void PrintCashiers() {
        System.out.print("CASHIERSS: ");
        for (Cashier c: cashiers) {
            System.out.print("Cashier " + c.getCashierId() + ", ");
        }
        System.out.println();
    }

}
