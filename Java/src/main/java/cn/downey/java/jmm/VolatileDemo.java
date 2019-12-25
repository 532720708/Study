package cn.downey.java.jmm;

import java.util.concurrent.TimeUnit;

class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number++;
    }

}

/**
 * 1   验证volatile的可见性
 * 1.1  假如 int number = 0; number变量之前根本没有添加volatile关键字，没有可见性
 * 1.2  添加了volatile，可以解决可见性问题
 * <p>
 * 2 验证volatile不保证原子性
 * 2.1  原子性指的是什么意思？
 * 不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者是被分割。
 * 需要整体完整，要么同时成功，要么同时失败。
 * 2.2 volatile不保证原子性
 * 2.3 为什么不保证原子性
 */
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData.number);
    }

    /**
     * volatile可以保证可见性，及时通知其它线程，主物理内存的值已经被修改。
     */
    private static void seeOkByVolatile() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value:" + myData.number);
        }, "AAA").start();

        while (myData.number == 0) {
            //main线程就一直在这里等待循环，直到number值不再等于零
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}
