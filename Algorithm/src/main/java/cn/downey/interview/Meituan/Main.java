package cn.downey.interview.Meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");
        int[] A = new int[line2.length];
        for (int i = 0; i < line2.length; i++) {
            A[i] = Integer.parseInt(line2[i]);
        }
        System.out.println(least(Integer.parseInt(line1[0]),
                Integer.parseInt(line1[1]),
                A));
    }

    private static int least(int n, int x, int[] A) {
        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);
        int ans = Integer.MAX_VALUE;
//        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[j] - A[i] <= x) {
                    ans = Math.min(ans, n - (j - i) - 1);
                }
//                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
//                }
            }
//            ans = Math.min(ans,dp[i][j]);
        }
        return ans;
    }
}
