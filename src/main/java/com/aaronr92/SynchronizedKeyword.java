package com.aaronr92;

public class SynchronizedKeyword {
    // A synchronized method must be outside runnable
    public static int value = 0;
    public static void main(String[] args) throws InterruptedException {
        IncrementThread t1 = new IncrementThread();
        IncrementThread t2 = new IncrementThread();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(value);
    }
}

class IncrementThread extends Thread {
    /**
     * A synchronized method must be outside runnable
     */
    public static synchronized void increment() {
        SynchronizedKeyword.value++;
    }
    @Override
    public synchronized void run() {
        for (int i = 0; i < 10_000; i++) {
            increment();
        }
    }
}