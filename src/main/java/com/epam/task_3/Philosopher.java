package com.epam.task_3;

import java.util.concurrent.Semaphore;

/**
 * Created by Mayer Roman on 24.05.2016.
 */
public class Philosopher implements Runnable {
    private int philosopherNumber;
    private Semaphore waiter;

    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(int philosopherNumber, Semaphore waiter, Fork leftFork, Fork rightFork) {
        this.philosopherNumber = philosopherNumber;
        this.waiter = waiter;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void run() {
        while (true) {
            think();
            eat();
        }

    }

    private void think() {
        System.out.println("Philosopher " + philosopherNumber + " THINKING");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        try {
            waiter.acquire();
            leftFork.takeFork();
            rightFork.takeFork();
            System.out.println("Philosopher " + philosopherNumber + " EAT");
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rightFork.putFork();
            leftFork.putFork();
            waiter.release();
        }
    }
}
