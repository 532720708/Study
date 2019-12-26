package cn.downey.java.jmm;

public class SingletonDemo {

    //在需要单例的对象前加volatile，禁止指令重排
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t我是构造方法");
    }

    /**
     * DCL (Double Check Lock 2层锁)
     *
     * @return
     */
    public static SingletonDemo getInstance() {
        if (instance == null) {
            //在加锁前和后都进行判断
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 1000000000; i++) {
            new Thread(SingletonDemo::getInstance, String.valueOf(i)).start();
        }
    }
}
