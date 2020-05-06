package cn.downey.interview.Kuaishou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(",");
        Main2 main = new Main2();
        System.out.println(Arrays.toString(main.GetPowerFactor(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]))));
    }

    public int[] GetPowerFactor(int R, int N) {
        ArrayList<Integer> list = new ArrayList<>();
        while (R > 0) {
            list.add(R % N);
            R /= N;
        }
        System.out.println(list);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                ans.add(i);
            } else {
                return new int[]{};
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

}
