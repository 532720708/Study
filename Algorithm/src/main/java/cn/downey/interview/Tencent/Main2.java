package cn.downey.interview.Tencent;

import java.util.Scanner;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < times; i++) {
            int count = Integer.parseInt(scanner.nextLine());
            func(count);
        }
    }

    private static void func(int count) {
        Point[] a = new Point[count];
        Point[] b = new Point[count];
        for (int i = 0; i < count; i++) {
            String[] str = scanner.nextLine().split(" ");
            a[i] = new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
        for (int i = 0; i < count; i++) {
            String[] str = scanner.nextLine().split(" ");
            b[i] = new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                min = Math.min(Math.sqrt(Math.pow(a[i].x - b[j].x, 2) + Math.pow(a[i].y - b[j].y, 2)), min);
            }
        }
        System.out.println(String.format("%.3f", min));
    }
}
