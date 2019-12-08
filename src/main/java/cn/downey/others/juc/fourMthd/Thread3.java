package cn.downey.others.juc.fourMthd;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 3.覆写Callable接口实现多线程（JDK1.5）
 * a.核心方法叫call()方法，有返回值
 * b.有返回值
 */
public class Thread3 implements Callable<String> {
    private int count = 20;

    @Override
    public String call() throws Exception {
        for (int i = count; i > 0; i--) {
//			Thread.yield();
            System.out.println(Thread.currentThread().getName() + "当前票数：" + i);
        }
        return "sale out";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> callable = new Thread3();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread mThread = new Thread(futureTask);
        Thread mThread2 = new Thread(futureTask);
        Thread mThread3 = new Thread(futureTask);
//		mThread.setName("hhh");
        mThread.start();
        mThread2.start();
        mThread3.start();
        System.out.println(futureTask.get());
    }
}
