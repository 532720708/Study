package cn.downey.java.jvm;

import java.util.Random;

/**
 * 1 DefNew+Tenured
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 * <p>
 * 2 ParNew+Tenured
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC
 * <p>
 * 3 PSYoungGen+ParOldGen
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("************GCDemo hello");
        try {
            String str = "atguigu";
            while (true) {
                str += str + new Random().nextInt(77777777) + new Random().nextInt(88888888);
                str.intern();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
