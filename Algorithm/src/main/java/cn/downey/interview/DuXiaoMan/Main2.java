package cn.downey.interview.DuXiaoMan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        int[] a = new int[Integer.parseInt(line1[0])];
        for (int i = 0; i < line2.length; i++) {
            a[i] = Integer.parseInt(line2[i]) - 1;
        }
        System.out.println(func(
                1,
                Integer.parseInt(line1[1]),
                Integer.parseInt(line1[2]),
                Integer.parseInt(line1[3]), a,
                0));
    }

    private static int func(int N, int A, int B, int C, int[] a, int cost) {
        if (N == a.length) {
            return cost;
        }
        cost += Math.min(Math.min(
                func(a[N], A, B, C, ArrayB(a, N), cost + B),
                func(a[N], A, B, C, ArrayC(a, N), cost + C)),
                func(a[N], A, B, C, a, cost + A));
        return cost;
    }

    private static int[] ArrayB(int[] a, int N) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = i == N ? a[i] - 1 : a[i];
        }
        return b;
    }

    private static int[] ArrayC(int[] a, int N) {
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = i == N ? a[i] + 1 : a[i];
        }
        return c;
    }
}
