package cn.downey.interview.Tencent;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] str = scanner.nextLine().split(" ");
            func(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
    }

    private static void func(int m, int n) {
        int curParent = (int) (Math.floor(Math.log(m / 2) / Math.log(2))) + 1;
        if (curParent == n) {
            System.out.println(m / 2);
        } else if (curParent > n) {
            func(m / 2, n);
        } else {
            System.out.println(-1);
        }
    }
}
