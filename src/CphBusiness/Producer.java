package CphBusiness;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
    BlockingQueue<Integer> s1;
    BlockingQueue<Integer> s2;

    public Producer(BlockingQueue<Integer> s1, BlockingQueue<Integer> s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        boolean keepRunning = true;

        while (keepRunning) {
            try {
                s2.put(fib(s1.take()));
            } catch (InterruptedException e) {
                e.printStackTrace();
                keepRunning = false;
            }
        }

    }

    int fib(int n) {
        if (n < 2) return n;
        return fib(n - 1) + fib(n - 2);
    }
}