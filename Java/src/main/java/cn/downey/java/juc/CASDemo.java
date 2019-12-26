package cn.downey.java.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1    CAS是什么？
 * 比较并交换(compare and set)
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data: " + atomicInteger);
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data: " + atomicInteger);


    }
}
