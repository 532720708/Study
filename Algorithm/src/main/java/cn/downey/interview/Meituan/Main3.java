//package cn.downey.interview.Meituan;
//
//import java.util.Scanner;
//
//public class Main3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        String[] line2 = sc.nextLine().split(" ");
//        String[] line3 = sc.nextLine().split(" ");
//        double[] p = new double[line2.length];
//        int[] a = new int[line3.length];
//        for (int i = 0; i < line2.length; i++) {
//            p[i] = Double.parseDouble(line2[i]);
//        }
//        for (int i = 0; i < line3.length; i++) {
//            a[i] = Integer.parseInt(line3[i]);
//        }
//        System.out.println(score(n, p, a));
//    }
//
//    private static double score(int n, double[] p, int[] a) {
//        double ans = 0;
//        double[][] dp = new double[n][n];
//        for (int i = 0; i < n; i++) {
//            dp[0][i] = p[i];
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[i][j] = Math.max
//            }
//        }
//        return ans;
//        ;
//    }
//
//}
