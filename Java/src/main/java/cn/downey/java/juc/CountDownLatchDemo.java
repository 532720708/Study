package cn.downey.java.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞
 * 其它线程调用countDown方法时，会将计数器减1(调用countDown方法的线程不会阻塞)
 * 当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行
 */
public class CountDownLatchDemo {

    private static final int NUM = 6;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(NUM);
        for (int i = 1; i <= NUM; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "\t班长关门");
    }

    private static void CloseDoor() {
        for (int i = 1; i <= NUM; i++) {
            new Thread(() -> System.out.println(Thread.currentThread().getName() + "\t离开教室"), String.valueOf(i)).start();
        }

        System.out.println(Thread.currentThread().getName() + "\t班长关门");
    }
}
