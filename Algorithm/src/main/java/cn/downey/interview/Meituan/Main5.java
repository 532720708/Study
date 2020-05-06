package cn.downey.interview.Meituan;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] line2 = sc.nextLine().split(" ");
        int[] A = new int[line2.length];
        for (int i = 0; i < line2.length; i++) {
            A[i] = Integer.parseInt(line2[i]);
        }
        System.out.println(solution(n, A));

    }

    private static int solution(int n, int[] a) {
        int ans = a[0] ^ a[1];
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (i == 0 && j == 1) {
                    continue;
                }
                ans = ans ^ xor(i, j, a);
            }
        }
        return ans;
    }

    private static int xor(int i, int j, int[] a) {
        int min = a[i];
        int max = a[j];
        for (int m = i; m <= j; m++) {
            min = Math.min(a[m], min);
            max = Math.max(a[m], max);
        }

        return min ^ max;
    }
}
