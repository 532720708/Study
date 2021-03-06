package cn.downey.java.juc;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 对于CountDownLatch，当计数为0的时候，下一步的动作实施者是main函数；
 * 对于CyclicBarrier，下一步动作实施者是“其他线程”。
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //CycleBarrier(int parties, Runnable barrierAction)
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Execute!");
        });
        System.out.println("main");
        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + temp);
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }


    }
}
