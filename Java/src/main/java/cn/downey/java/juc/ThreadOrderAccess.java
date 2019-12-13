package cn.downey.java.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareRescource {
    private int number = 1;//1:A, 2:B, 3:C
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            //1 判断
            while (number != 1) {
                condition1.await();
            }
            //2 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //1 判断
            while (number != 2) {
                condition2.await();
            }
            //2 干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //1 判断
            while (number != 3) {
                condition3.await();
            }
            //2 干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


/**
 * 多线程之间按顺序调用，A->B->C
 * A打印5次，B打印10次，C打印15次
 * 进行十轮
 * <p>
 * 1        高内聚低耦合前提下，线程操作资源类
 * 2        判断/干活/通知
 * 3        多线程交互中，必须要防止多线程的虚假唤醒，也即(判断只用while,不用if)
 * 4        注意标志位
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareRescource shareRescource = new ShareRescource();
        new Thread(shareRescource::print5, "AAAAA").start();

        new Thread(shareRescource::print10, "BBBBB").start();

        new Thread(shareRescource::print15, "CCCCC").start();

    }
}
