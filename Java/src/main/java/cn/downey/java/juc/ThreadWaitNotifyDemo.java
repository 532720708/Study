package cn.downey.java.juc;

class AirConditioner {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        //1.判断
        while (number != 0) {
            this.wait();
        }
        //2.干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //3.通知
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        //1.判断
        while (number == 0) {
            this.wait();
        }
        //2.干活
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //3.通知
        this.notifyAll();
    }

}

/**
 * 题目：现在两个线程，可以操作初始值为0的一个变量，
 * 实现一个多线程对该变量加1，一个线程对该变量减1，
 * 实现交替，来10轮，变量初始值为零
 * <p>
 * 1        高内聚低耦合前提下，线程操作资源类
 * 2        判断/干活/通知
 * 3        多线程交互中，必须要防止多线程的虚假唤醒，也即(判断只用while,不用if)
 */
public class ThreadWaitNotifyDemo {
    private static final int TIMES = 50;

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                try {
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                try {
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                try {
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                try {
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}
