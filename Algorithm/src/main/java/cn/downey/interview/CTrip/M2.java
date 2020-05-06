package cn.downey.interview.CTrip;

import java.util.Scanner;

public class M2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static long countDolphin(int n, int m, int[] birthYear, int x) {
        return n * singleDolphin(m, birthYear, x);
    }

    private static long singleDolphin(int m, int[] birthYear, int x) {
        int curDol = 1;
        for (int i = 0; i <= x; i++) {
            if (isBirthYear(i, birthYear)) {
                curDol += singleDolphin(m, birthYear, x - i);
            }
        }
        return curDol;
    }

    static boolean isBirthYear(int i, int[] birthYear) {
        for (int j : birthYear) {
            if (i == j) {
                return true;
            }
        }
        return false;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _birthYear_size = 0;
        _birthYear_size = Integer.parseInt(in.nextLine().trim());
        int[] _birthYear = new int[_birthYear_size];
        int _birthYear_item;
        for (int _birthYear_i = 0; _birthYear_i < _birthYear_size; _birthYear_i++) {
            _birthYear_item = Integer.parseInt(in.nextLine().trim());
            _birthYear[_birthYear_i] = _birthYear_item;
        }

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = countDolphin(_n, _m, _birthYear, _x);
        System.out.println(String.valueOf(res));

    }
}

