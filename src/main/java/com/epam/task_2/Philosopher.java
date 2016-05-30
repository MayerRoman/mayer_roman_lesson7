package com.epam.task_2;

/**
 * Created by Mayer Roman on 24.05.2016.
 */
public class Philosopher implements Runnable {
    private int philosopherNumber;

    private Fork leftFork;
    private Fork rightFork;

    Philosopher(int philosopherNumber, Fork leftFork, Fork rightFork) {
        this.philosopherNumber = philosopherNumber;
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

    private void eat(){
        synchronized (leftFork) {
            synchronized (rightFork) {
                System.out.println("Philosopher " + philosopherNumber + " EAT");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
