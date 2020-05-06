package cn.downey.interview.WeBank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int a = Integer.parseInt(line1[2]);
        int b = Integer.parseInt(line1[3]);
        Main main = new Main();
        System.out.println(main.calculate(n, m, a, b));
    }

    /**
     * 有n位小朋友去小明家里拜年，小明准备了m份礼物。小明想把所有礼物平均分给每个小朋友，
     * 每个小朋友得到相同个数的礼物。但是m未必能被n整除，
     * 小明可以使用以下两种操作任意多次（两种操作可以同时使用）。
     * 1、 给其中一个小朋友发红包，收到红包的小朋友会离开小明家。每个红包需要花费a元。
     * 2、 购买一个新礼物，每个礼物价值为b元。
     * 问小明最少花费多少元，才能使得所有礼物可以被剩下的小朋友平分。
     */
    private int calculate(int n, int m, int a, int b) {
        if (m % n == 0) {
            return 0;
        } else {
            return Math.min(calculate(n - (int) Math.ceil(a / b), m, a, b) + a, calculate(n, m + (int) Math.ceil(b / a), a, b) + b);
        }
    }
}
