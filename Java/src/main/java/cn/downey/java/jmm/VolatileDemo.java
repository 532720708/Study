package cn.downey.java.jmm;

import java.util.concurrent.TimeUnit;

class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

}

/**
 * 1   验证volatile的可见性
 * 1.1  假如 int number = 0; number变量之前根本没有添加volatile关键字，没有可见性
 */
public class VolatileDemo {

    public static void main(String[] args) {

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
