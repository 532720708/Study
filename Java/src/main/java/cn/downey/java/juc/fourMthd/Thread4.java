package cn.downey.java.juc.fourMthd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 4.通过线程池启动多线程
 */
public class Thread4 {
    public static void main(String[] args) {
        //1.固定大小的线程池
        FixedThreadPool(5);
        //2.单线程池
        SingleThreadPoolExecutor();
        //3.缓存线程池
        CashedThreadPool();

    }

    static void FixedThreadPool(int k) {
        ExecutorService ex = Executors.newFixedThreadPool(k);
        for (int i = 0; i < 5; i++) {
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + j);
                    }
                }
            });
        }
        ex.shutdown();
    }

    static void SingleThreadPoolExecutor() {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + j);
                    }

                }
            });
        }
        ex.shutdown();
    }

    static void CashedThreadPool() {
        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + j);
                    }
                }
            });
        }
        ex.shutdown();
    }
}
