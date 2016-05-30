package com.epam.task_1;

import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Mayer Roman on 24.05.2016.
 */
public class Counter implements Runnable{
    private static LongAdder count = new LongAdder();

    public void run() {
        for (int i = 0; i < 100000; i++) {
            count.increment();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Counter()).start();
        }

        while (count.intValue() != 10000000) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(count.intValue());
    }

}
