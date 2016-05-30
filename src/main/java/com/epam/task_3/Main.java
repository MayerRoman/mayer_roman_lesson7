package com.epam.task_3;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Mayer Roman on 24.05.2016.
 */
public class Main {

    public static void main(String[] args) {
        Semaphore waiter = new Semaphore(4, true);

        Fork fork1 = new Fork(new ReentrantLock());
        Fork fork2 = new Fork(new ReentrantLock());
        Fork fork3 = new Fork(new ReentrantLock());
        Fork fork4 = new Fork(new ReentrantLock());
        Fork fork5 = new Fork(new ReentrantLock());

        Thread thread1 = new Thread(new Philosopher(1, waiter, fork1, fork5));
        Thread thread2 = new Thread(new Philosopher(2, waiter, fork2, fork1));
        Thread thread3 = new Thread(new Philosopher(3, waiter, fork3, fork2));
        Thread thread4 = new Thread(new Philosopher(4, waiter, fork4, fork3));
        Thread thread5 = new Thread(new Philosopher(5, waiter, fork5, fork4));


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
