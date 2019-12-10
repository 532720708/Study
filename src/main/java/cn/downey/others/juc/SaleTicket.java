package cn.downey.others.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    private int number = 600;
    private Lock lock = new ReentrantLock();

    public void saleTicket() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + number-- + "\t还剩下：" + number);
            }
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 题目：三个售票员         卖出          30张票
 * <p>
 * 多线程编程的企业级套路+模板
 * <p>
 * 1    在高内聚、低耦合的前提下，线程     操作（对外暴露的调用方法）      资源类
 */
public class SaleTicket {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        //Thread的start()并不会立即执行，而是进入就绪，等操作系统调度
        //sleep结束后锁依然在自己手里
        //wait结束后失去锁
        //Thread.State 多线程的状态

        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket.saleTicket();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket.saleTicket();
            }
        }, "B").start();


        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket.saleTicket();
            }
        }, "C").start();
    }
}
