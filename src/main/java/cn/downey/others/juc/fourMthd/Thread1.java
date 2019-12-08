package cn.downey.others.juc.fourMthd;

/**
 * 1.继承Thread类实现多线程
 * run()为线程类的核心方法，相当于主线程的main方法，是每个线程的入口
 * a.一个线程调用 两次start()方法将会抛出线程状态异常，也就是的start()只可以被调用一次
 * b.native生明的方法只有方法名，没有方法体。是本地方法，不是抽象方法，而是调用c语言方法
 * registerNative()方法包含了所有与线程相关的操作系统方法
 * c. run()方法是由jvm创建完本地操作系统级线程后回调的方法，不可以手动调用（否则就是普通方法）
 */
public class Thread1 extends Thread {
    public Thread1() {

    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + ":" + i);
        }
    }

    public static void main(String[] args) {
        Thread1 mThread1 = new Thread1();
        Thread1 mThread2 = new Thread1();
        Thread1 mThread3 = new Thread1();
        mThread1.start();
        mThread2.start();
        mThread3.start();
    }
}
