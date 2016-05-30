package com.epam.task_2;

/**
 * Created by Mayer Roman on 24.05.2016.
 */
public class Main {


    public static void main(String[] args) {
        Fork fork1 = new Fork();
        Fork fork2 = new Fork();
        Fork fork3 = new Fork();
        Fork fork4 = new Fork();
        Fork fork5 = new Fork();

        Thread thread1 = new Thread(new Philosopher(1, fork1, fork5));
        Thread thread2 = new Thread(new Philosopher(2, fork2, fork1));
        Thread thread3 = new Thread(new Philosopher(3, fork3, fork2));
        Thread thread4 = new Thread(new Philosopher(4, fork4, fork3));
        Thread thread5 = new Thread(new Philosopher(5, fork4, fork5));


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
