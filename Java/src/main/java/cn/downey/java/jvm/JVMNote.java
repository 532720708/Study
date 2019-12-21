package cn.downey.java.jvm;

/**
 * 5 方法区
 * 5.1  它存储了每一个类的结构信息
 * 5.2  方法区是规范，在不同虚拟机里头实现是不一样的，最典型的就是
 * 永久代（PermGen space）和元空间（MetaSpace）
 * 实例变量存在堆内存中，和方法区无关
 * <p>
 * 6 Stack
 * 6.1  栈管运行，堆管存储
 * 6.2  栈保存的内容:
 * 8种基本类型的变量+对象的引用变量+实例方法
 *
 * @author zsj53
 */
public class JVMNote {

    public int add(int x, int y) {
        int result = -1;
        result = x + y;
        return result;
    }

    public static void m1() {
        System.out.println("********m1");
    }

    public static void main(String[] args) {
        m1();
    }

//    Throwable throwable = new OutOf

}
