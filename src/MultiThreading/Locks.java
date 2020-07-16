package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

//https://www.baeldung.com/java-concurrent-locks
//
//Types of locks :
//1. ReadWriteLock  - allows readers but not write eg : lock.writeLock().lock(); lock.readLock().lock();
//2. ReentrantLock
public class Locks {

    //if fair set to true granting access to the longest-waiting thread.
    // ReentrantLock is mutual exclusion lock
    ReentrantLock lock = new ReentrantLock(true);
    int counter = 0;
    int count;

    public void perform() {
        lock.lock();
        try {
            // Critical section here
            count++;
        } finally {
            lock.unlock();
        }
    }
}
