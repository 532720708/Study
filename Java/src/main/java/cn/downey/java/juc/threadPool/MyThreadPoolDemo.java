package cn.downey.java.juc.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池 = 一个银行网点
 * int corePoolSize                     =   今日当值窗口
 * int maximumPoolSize                  =   所有窗口（候客区满了，对corePoolSize进行扩容）
 * long keepAliveTime                   =   扩容出来的窗口没事情干超过一定时间
 * TimeUnit unit                        =   keepAliveTime的单位
 * BlockingQueue<Runnable> workQueue    =   候客区
 * ThreadFactory threadFactory          =
 * RejectedExecutionHandler handler     =   所有窗口和候客区都满了，拒绝顾客（饱和拒绝策略）
 */
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
