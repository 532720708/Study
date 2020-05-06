package cn.downey.interview.Kuaishou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Customer {
    int id;
    int ai;
    int bi;

    public Customer(int id, int ai, int bi) {
        this.id = id;
        this.ai = ai;
        this.bi = bi;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ArrayList<Integer> arrayList = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar <= '9' && aChar >= '0') {
                arrayList.add(Integer.parseInt(String.valueOf(aChar)));
            }
        }
        int len = arrayList.size();
        int[] ais = new int[len / 2];
        int[] bis = new int[len / 2];
        for (int i = 0; i < len; i++) {
            if (i < len / 2) {
                ais[i] = arrayList.get(i);
            } else {
                bis[i - len / 2] = arrayList.get(i);
            }
        }
        System.out.println(Arrays.toString(WaitInLine(ais, bis)));
    }

    public static int[] WaitInLine(int[] a, int[] b) {
        Customer[] customers = new Customer[a.length];
        for (int i = 0; i < a.length; i++) {
            customers[i] = new Customer(i + 1, a[i], b[i]);
        }
        ArrayList<Customer[]> arrayList = new ArrayList<>();
        PermutationHelper(customers, 0, arrayList);
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Customer[]> hashMap = new HashMap<>();
        for (Customer[] customers1 : arrayList) {
            int temp = 0;
            for (int i = 0; i < customers1.length; i++) {
                if (i == 0) {
                    temp += customers1[i].bi * (customers1.length - (i + 1));
                } else if (i == customers1.length - 1) {
                    temp += customers1[1].ai * (i);
                } else {
                    temp += customers1[i].bi * (customers1.length - (i + 1)) + customers1[1].ai * (i);
                }
            }
            ans = Math.min(ans, temp);
            hashMap.put(ans, customers1);
        }
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = hashMap.get(ans)[i].id;
        }
        return res;
    }

    private static void PermutationHelper(Customer[] customers, int i, ArrayList<Customer[]> list) {
        if (i == customers.length - 1) {
            list.add(customers);
        } else {
            for (int j = i; j < customers.length; j++) {

                swap(customers, i, j);
                PermutationHelper(customers, i + 1, list);
                swap(customers, i, j);

            }
        }
    }

    private static void swap(Customer[] customers, int i, int j) {
        Customer temp = customers[i];
        customers[i] = customers[j];
        customers[j] = temp;
    }
}
