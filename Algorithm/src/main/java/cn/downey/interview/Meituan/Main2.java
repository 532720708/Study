package cn.downey.interview.Meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");
        List<Integer> A = new ArrayList<>();
        for (String s : line2) {
            A.add(Integer.parseInt(s));
        }
        System.out.println(cost(Integer.parseInt(line1[0]),
                Integer.parseInt(line1[1]),
                A));
    }

    private static int cost(int n, int m, List<Integer> a) {
        int ans = 0;
        int min = 0;
        for (int i : a) {
            min = Math.min(i, min);
        }
        int curPosition = 0;
        while (m > min) {
            if (a.get(curPosition) <= m) {
                m -= a.get(curPosition);
                ans++;
                curPosition++;
            } else {
                a.remove(curPosition);
                n--;
            }
            curPosition = curPosition % n;

        }
        return ans;
    }
}
