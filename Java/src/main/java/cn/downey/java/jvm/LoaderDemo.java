package cn.downey.java.jvm;

public class LoaderDemo {
    public static void main(String[] args) {
        //在rt.jar中，由(启动类)根加载器加载进虚拟机
        Object object = new Object();
        String str = new String();

        //启动类加载器加载最原始的java包
        //扩展类加载器加载java的扩展包
        //应用程序类加载器加载自定义的类（classpath所有类）

    }
}
