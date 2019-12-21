package cn.downey.java.jvm;

/**
 * @author zsj53
 */
public class StaticDemo {

    //静态代码块和静态成员变量按照代码顺序加载到类模板
    static {
        //如果不print，则不加载类对象，编译可以通过
        name = 5;

        //一旦print，则需要加载类对象，编译不通过
        //System.out.println(name);
    }

    static int name;

    /**
     * 加载顺序：静态变量/静态代码块 -> 静态方法-> 成员变量（普通代码块） -> 构造方法
     */
    StaticDemo() {
        test();
        System.out.println("Constructor loaded！");

    }

    static void test() {
        System.out.println(name);
        System.out.println("Static method loaded！");
    }

    public static void main(String[] args) {
        StaticDemo.test(); //不会加载构造函数

    }
}
