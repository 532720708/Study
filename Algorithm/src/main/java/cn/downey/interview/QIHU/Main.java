package cn.downey.interview.QIHU;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int[] fighter = new int[n];
        for (int i = 0; i < n; i++) {
            fighter[i] = Integer.parseInt(line2[i]);
        }
        System.out.println(func(n, m, fighter));
    }

    private static int func(int n, int m, int[] fighter) {
        int curWin = 0;
        int round = 0;
        int Winner = Math.max(fighter[0], fighter[1]);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i : fighter) {
            deque.addFirst(i);
        }
        while (curWin != m) {
            int a0 = deque.pollFirst();
            int a1 = deque.pollFirst();
            if (a0 > a1) {
                if (Winner == a0) {
                    curWin++;
                } else {
                    Winner = a0;
                    curWin = 0;
                }
                deque.addFirst(a0);
                deque.addLast(a1);
            } else {
                if (Winner == a1) {
                    curWin++;
                } else {
                    Winner = a1;
                    curWin = 0;
                }
                deque.addFirst(a1);
                deque.addLast(a0);
            }
            round++;
        }
        return round;
    }


}