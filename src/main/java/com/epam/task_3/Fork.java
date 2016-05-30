package com.epam.task_3;

import java.util.concurrent.locks.Lock;

/**
 * Created by Mayer Roman on 29.05.2016.
 */
public class Fork {
    Lock lock;

    public Fork(Lock lock) {
        this.lock = lock;
    }

    public void takeFork() {
        lock.lock();
    }

    public void putFork() {
        lock.unlock();
    }
}
