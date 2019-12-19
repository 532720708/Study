package cn.downey.java.jvm;

public class LoaderDemo {
    public static void main(String[] args) {
        //在rt.jar中，由(启动类)根加载器加载进虚拟机
        Object object = new Object();
        String str = new String();

        //BootstrapClassLoader：启动类加载器加载最原始的java包
        //ExtensionClassLoader：扩展类加载器加载java的扩展包
        //App ClassLoader     ：应用程序类加载器加载自定义的类（classpath所有类）

        //用户自定义加载器     ：Java.lang.ClassLoader的子类，用户可以定制类的加载方式

    }
}
