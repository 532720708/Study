package cn.downey.interview.AliBaBa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        int[] monsters = new int[Integer.parseInt(line1[1])];
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = Integer.parseInt(line2[i]);
        }
        System.out.println(func(
                Integer.parseInt(line1[0]),
                Integer.parseInt(line1[1]), monsters));
    }

    private static int func(int a, int n, int[] monsters) {
        Arrays.sort(monsters);
        int[] dp = new int[n];
        if (a < monsters[0]) {
            return 0;
        }
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (a >= monsters[i]) {
                dp[i] = dp[i - 1] + 1;
            } else if (a + 1 >= monsters[i]) {
                a += 1;
                dp[i] = dp[i - 1];
            } else if (a + 1 < monsters[i]) {
                return dp[i - 1];
            }
            res = Math.max(res, dp[i]);
            System.out.println(dp[i]);
        }
        return res;
    }
}
