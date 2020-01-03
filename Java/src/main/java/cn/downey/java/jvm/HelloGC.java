package cn.downey.java.jvm;

public class HelloGC {
    public static void main(String[] args) throws Exception {
        System.out.println("HelloGC");

        Thread.sleep(Integer.MAX_VALUE);
    }
}
