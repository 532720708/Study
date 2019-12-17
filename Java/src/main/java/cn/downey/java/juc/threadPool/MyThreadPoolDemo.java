package cn.downey.java.juc.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolDemo {
    public static void main(String[] args) {


        //Executor  ->  ExecutorService  ->  ThreadPoolExecutor
        // ->  ThreadPoolExecutor(围绕这个)

        ExecutorService threadPool = Executors.newFixedThreadPool(5); //一池5个受理线程，类似一个银行5个受理窗口
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor(); //一池1个受理线程，类似一个银行5个受理窗口
        ExecutorService threadPool3 = Executors.newCachedThreadPool(); //一池n个受理线程，类似一个银行N个受理窗口
        try {
            //模拟有10个顾客过来银行办理业务，目前有5个工作人员提供服务
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "\t办理业务"));
                TimeUnit.MILLISECONDS.sleep(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
