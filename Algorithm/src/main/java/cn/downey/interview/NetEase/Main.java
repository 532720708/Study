package cn.downey.interview.NetEase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        char[][] input = new char[n][m];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextLine().toCharArray();
        }
        func(input, n, m);
    }

    private static void func(char[][] input, int n, int m) {
        int[][] dp = new int[n + 2][m + 2];
        char[][] temp = new char[n + 2][m + 2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                temp[i][j] = input[i - 1][j - 1];
            }
        }
        for (int i = 0; i < m + 2; i++) {
            dp[0][i] = Integer.MAX_VALUE;
            dp[n + 1][i] = Integer.MAX_VALUE;
            temp[0][i] = '1';
            temp[n + 1][i] = '1';
        }
        for (int i = 0; i < n + 2; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[m + 1][0] = Integer.MAX_VALUE;
            temp[i][0] = '1';
            temp[m + 1][0] = '1';
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (temp[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (temp[i][j - 1] == '0' || temp[i][j + 1] == '0' || temp[i - 1][j] == '0' || temp[i + 1][j] == '0') {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] += 1 + Math.min(dp[i - 1][j], Math.max(dp[i + 1][j], Math.min(dp[i][j - 1], dp[i][j + 1])));
                    }
                }
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (j == m) {
                    System.out.print(dp[i][j]);
                } else {
                    System.out.print(dp[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
