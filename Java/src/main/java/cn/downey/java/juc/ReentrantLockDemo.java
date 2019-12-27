package cn.downey.java.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class iPhone implements Runnable {

    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getId() + "\t invoked sendSMS");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getId() + "\t invoked sendEmail");
    }

    Lock lock = new ReentrantLock(false);

    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked set()");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        get();
    }
}

/**
 * 可重入锁指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 * 在同一个线程在外层方法获取锁的时候，进入内层方法会自动获取锁
 * <p>
 * 也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
 */
public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        iPhone iPhone = new iPhone();

        new Thread(iPhone::sendSMS, "t1").start();

        new Thread(iPhone::sendSMS, "t2").start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println();
        System.out.println();
        System.out.println();

        Thread t3 = new Thread(iPhone, "t3");
        Thread t4 = new Thread(iPhone, "t4");

        t3.start();
        t4.start();

    }
}
