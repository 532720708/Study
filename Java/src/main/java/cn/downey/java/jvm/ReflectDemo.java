package cn.downey.java.jvm;

class Student {
    private int id;
    String name;
    protected boolean sex;
    public float score;
}

/**
 * 获取反射的三种方式
 * 1.通过Object类的getClass获取
 * 2.使用.class方式
 * 3.使用Class.forName方法
 */
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        //方式一
        Student student = new Student();
        Class class1 = student.getClass();
        System.out.println(class1.getName());

        //方式二
        Class class2 = Student.class;
        System.out.println(class2.getName());

        //方式三
        Class class3 = Class.forName("cn.downey.java.jvm.Student");
        System.out.println(class3.getName());
    }
}
