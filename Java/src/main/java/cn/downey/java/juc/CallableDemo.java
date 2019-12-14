package cn.downey.java.juc;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

//方法名、异常、返回值(泛型)的区别
class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t" + System.currentTimeMillis() + "\t" + "Come in here");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1024;
    }

}

/**
 * 多线程中，第三种获得线程的方式
 * Future implements FutureRunnable implements Runnable
 * Future的构造方法包含Callable
 * <p>
 * 1    get方法一般放在最后一行
 */
public class CallableDemo {
    public static void main(String[] args) throws Exception {
        FutureTask futureTask = new FutureTask(new MyThread());

        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();
        //只会返回一次

        System.out.println(Thread.currentThread().getName() + "\t" + "*****计算完成");

        System.out.println(futureTask.get());

    }
}
