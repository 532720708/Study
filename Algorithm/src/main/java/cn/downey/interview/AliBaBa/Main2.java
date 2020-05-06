package cn.downey.interview.AliBaBa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static ArrayList[] tu;
    public static int minLen = Integer.MAX_VALUE;
    public static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            tu = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                tu[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                tu[u - 1].add(v);
            }
            for (int i = 0; i < n; i++) {
                if (tu[i].size() > 0) {
                    ArrayList<Integer> path = new ArrayList<>();
                    path.add(i);
                    dfs(path);
                }
            }
            System.out.println(minLen == Integer.MAX_VALUE ? -1 : minLen - 1);
        }
    }

    private static void dfs(ArrayList<Integer> path) {
        ArrayList<Integer> next = tu[path.get(path.size() - 1)];
        if (next.size() == 0) {
            if (a[path.get(0)] == a[path.get(path.size() - 1)]) {
                minLen = Math.min(minLen, path.size());
            }
            return;
        }
        for (int i = 0; i < next.size(); i++) {
            if (!path.contains(next.get(i))) {
                path.add(next.get(i));
                dfs(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
        }
    }
}
