package cn.downey.java.jmm;

public class ReSortSeqDemo {
    int a = 0;
    boolean flag = false;

    public void method01() {
        a = 1;
        flag = true;
    }

    public void method02() {
        if (flag) {
            a += 5;
            System.out.println("*****retValue: " + a);
        }
    }
}
