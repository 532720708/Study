package cn.downey.java.jvm.oom;

public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        stackOverFlowError();
    }

    private static void stackOverFlowError() {
        stackOverFlowError();
    }
}
