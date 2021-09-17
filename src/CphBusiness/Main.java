package CphBusiness;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> s1 = new ArrayBlockingQueue<>(11);
        BlockingQueue<Integer> s2 = new ArrayBlockingQueue<>(5);


        //Fills s1
        s1.put(4);
        s1.put(5);
        s1.put(8);
        s1.put(12);
        s1.put(21);
        s1.put(22);
        s1.put(34);
        s1.put(35);
        s1.put(36);
        s1.put(37);
        s1.put(42);

        //Initializes producer threads
        Thread p1 = new Producer(s1,s2);
        Thread p2 = new Producer(s1,s2);
        Thread p3 = new Producer(s1,s2);
        Thread p4 = new Producer(s1,s2);

        //Initializes consumer thread
        Thread c1 = new Consumer(s2);

        //Starts and joins all threads
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        c1.start();
        p1.join();
        p2.join();
        p3.join();
        p4.join();
        c1.join();



    }
}