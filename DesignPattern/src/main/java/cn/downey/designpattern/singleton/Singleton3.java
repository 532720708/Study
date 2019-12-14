package cn.downey.designpattern.singleton;

/**
 * 饿汉式
 * 推荐：利用静态构造函数
 */
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();

    Singleton3() {
    }

    public Singleton3 getInstance() {
        return instance;
    }
}
