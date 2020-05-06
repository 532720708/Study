package cn.downey.interview.WeBank;

import java.util.Scanner;

class StringObject {
    int i1;
    int i2;

    public StringObject(String str) {
        int[] table = new int[26];
        int i11 = 0;
        int i22 = 0;
        for (char c : str.toCharArray()) {
            table[c - 'a']++;
        }
        for (int i : table) {
            if (i % 2 == 1) {
                i11++;
            }
            i22 += i / 2;
        }
        this.i1 = i11;
        this.i2 = i22;
        System.out.println(i1 + "," + i2);
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        String[] strs = new String[t];
        for (int i = 0; i < t; i++) {
            strs[i] = scanner.nextLine();
        }
        Main2 main2 = new Main2();
        for (String str : strs) {
            System.out.println(main2.calculate(str));
        }
    }

    private String calculate(String str) {
        int i = 0;
        StringObject stringObject = new StringObject(str);
        while (stringObject.i1 + stringObject.i2 > 1) {
            if (stringObject.i1 == 1 || stringObject.i1 == 0) {
                break;
            }
            //如果奇数个大于1
            if (stringObject.i1 > 1) {
                //轮到C
                if (i % 2 == 0) {
                    //减少奇数字母个数
                    stringObject.i1--;
                }
                //轮到E
                else {
                    if (stringObject.i2 - 1 < 0) {
                        stringObject.i1--;
                    } else {
                        stringObject.i2--;
                        stringObject.i1++;
                    }
                }
                i++;
            }
        }
        return i % 2 == 0 ? "Cassidy" : "Eleanore";
    }

}
