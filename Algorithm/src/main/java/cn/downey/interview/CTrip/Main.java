package cn.downey.interview.CTrip;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String[] words = new String[]{"surprise", "happy", "ctrip",
                "travel", "wellcome", "student",
                "system", "program", "editor"};
        String ans = "null";
        for (String str : words) {
            if (check(str, word)) {
                ans = str;
                break;
            }
        }
        System.out.println(ans);
    }


    private static boolean check(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < s2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[s1.length()][s2.length()] == 2;
    }
}
