package cn.downey.leetcode.designpattern.singleton;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 */
public class Singleton4 {
    private volatile static Singleton4 singleton4;

    private Singleton4() {
    }

    public static Singleton4 getSingleton4() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
