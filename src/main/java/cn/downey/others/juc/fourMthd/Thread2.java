package cn.downey.others.juc.fourMthd;

/**
 * 2.覆写Runnable()接口实现多线程，而后同样覆写run().推荐此方式
 * <p>
 * a.覆写Runnable接口实现多线程可以避免单继承局限
 * b.当子类实现Runnable接口，此时子类和Thread的代理模式（子类负责真实业务的操作，thread负责资源调度与线程创建辅助真实业务。
 */
public class Thread2 implements Runnable {
    public static int count = 20;

    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-当前剩余票数:" + count--);
        }
    }

    public static void main(String[] args) {
        Thread2 Thread1 = new Thread2();
        Thread mThread1 = new Thread(Thread1, "线程1");
        Thread mThread2 = new Thread(Thread1, "线程2");
        Thread mThread3 = new Thread(Thread1, "线程3");
        mThread1.start();
        mThread2.start();
        mThread3.start();
    }
}

