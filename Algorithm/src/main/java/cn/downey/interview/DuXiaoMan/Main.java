package cn.downey.interview.DuXiaoMan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        System.out.println(
                func(
                        Integer.parseInt(line1[0]),
                        Integer.parseInt(line1[1]),
                        Integer.parseInt(line1[2]),
                        Integer.parseInt(line1[3])));
    }

    private static int func(int n, int m, int a, int b) {
        int ans = 0;
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = ((i + 1) * (j + 1)) % 10;
            }
        }
        for (int i = 0; i < n - a + 1; i++) {
            for (int j = 0; j < m - b + 1; j++) {
                int max = Integer.MIN_VALUE;
                for (int x = 0; x < a; x++) {
                    for (int y = 0; y < b; y++) {
                        max = Math.max(max, matrix[x + i][y + j]);
                    }
                }
                ans += max;
            }
        }
        return ans;
    }
}
