package cn.downey.leetcode.designpattern.singleton;

public class SingletonPatternDemo {

    public static void main(String[] args) {
        Singleton1 object = Singleton1.getInstance();

        object.showMessage();
    }
}
