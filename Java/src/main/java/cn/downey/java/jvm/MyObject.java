package cn.downey.java.jvm;

/**
 * @author zsj53
 */
public class MyObject {
    public static void main(String[] args) {
        Object object = new Object();
        //Bootstrap是一个C++实现，没有对应的类
        System.out.println(object.getClass().getClassLoader());

        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader());

    }
}
