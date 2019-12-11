package cn.downey.java.juc;

class AirConditioner {
    private int number = 0;

    public void increment() throws InterruptedException {
        if (number != 0) {
            this.wait();
        }
        number++;
    }

    public void decrement() {
        number--;
    }

}

/**
 * 题目：现在两个线程，可以操作初始值为0的一个变量，
 * 实现一个多线程对该变量加1，一个线程对该变量减1，
 * 实现交替，来10轮，变量初始值为零
 * <p>
 * 1        高内聚低耦合前提下，线程操作资源类
 * 2        判断/干活/通知
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        new Thread(() -> {

        }).start();

        new Thread(() -> {

        }).start();
    }
}
