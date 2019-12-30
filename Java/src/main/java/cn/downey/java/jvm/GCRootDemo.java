package cn.downey.java.jvm;

/**
 * 在java中，可作为GCRoot的对象有：
 * 1、虚拟机栈（栈帧中的本地变量表）中引用的对象
 * 2、方法区中的类静态属性引用的对象
 * 3、方法区中常量引用的对象
 * 4、本地方法中的Native方法引用的对象
 */
public class GCRootDemo {
    private byte[] byteArray = new byte[100 * 1024 * 1024];

    public static void m1() {
        GCRootDemo t1 = new GCRootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        m1();
    }
}
