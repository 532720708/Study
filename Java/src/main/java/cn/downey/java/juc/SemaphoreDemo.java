package cn.downey.java.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 在信号量上定义两种操作，
 * 当一个线程调用acquire操作时，要么成功获得信号量，要么一直等下去，直到有线程释放信号量，或超时
 * release会将信号量的值加1，然后唤醒等待的线程
 * <p>
 * 主要用于：
 * 1、多个共享资源的互斥使用
 * 2、并发线程数的控制
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //如果换成1 就相当于synchronized
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t占用");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t释放");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
        }
    }
}
