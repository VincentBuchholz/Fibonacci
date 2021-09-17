package CphBusiness;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        int sum = 0;
        int taken = 0;

        while(!queue.isEmpty()){
            try {
                taken = queue.take();
                System.out.println("Fibonacci number:  " + taken);
                sum += taken;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Amount of number retrived: " + counter);
        System.out.println("Sum of Fibonacci numbers: " + sum);
    }
}