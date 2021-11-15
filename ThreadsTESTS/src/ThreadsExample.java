
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsExample implements Runnable {
    static int counter = 1; // a global counter

    static ReentrantLock counterLock = new ReentrantLock(true); // enable fairness policy

    static void incrementCounter(){
        counterLock.lock();

        // Always good practice to enclose locks in a try-finally block
        try{
            System.out.println(Thread.currentThread().getName() + ": " + counter);
            counter++;
        }finally{
             counterLock.unlock();
        }
     }

    @Override
    public void run() {
        while(counter<5){
            incrementCounter();
        }
    }
    public static void createThread(int nbr) {
    	
    	
        new Thread().start();
    }

    public static void main(String[] args) {
        ThreadsExample te = new ThreadsExample();
        te.createThread(5);
    }
}
