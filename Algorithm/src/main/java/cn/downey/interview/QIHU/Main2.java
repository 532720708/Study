package cn.downey.interview.QIHU;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int a0 = Integer.parseInt(line[1]);
        System.out.println(func(n, a0));
    }

    private static String func(int n, int a0) {
        double[][] dp = new double[n + 1][a0 + 1];
        dp[0][a0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= a0; j++) {
                for (int k = j; k <= a0; k++) {
                    dp[i][j] += dp[i - 1][k] / (k + 1);
                }
            }
        }
        return String.format("%.5f", dp[n][0]);
    }

}
