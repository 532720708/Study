package cn.downey.interview.Tencent;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<Integer> linkedList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int time = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < time; i++) {
            int count = Integer.parseInt(scanner.nextLine());
            func(count);
            linkedList.clear();
        }
    }

    private static void func(int operator) {
        for (int i = 0; i < operator; i++) {
            String[] str = scanner.nextLine().split(" ");
            if (str.length == 2) {
                if (str[0].equals("PUSH")) {
                    linkedList.push(Integer.parseInt(str[1]));
                }
            } else if (str.length == 1) {
                switch (str[0]) {
                    case "TOP":
                        if (linkedList.size() == 0) {
                            System.out.println(-1);
                        } else {
                            System.out.println(linkedList.getLast());
                        }
                        break;
                    case "SIZE":
                        System.out.println(linkedList.size());
                        break;
                    case "POP":
                        if (linkedList.size() == 0) {
                            System.out.println(-1);
                        } else {
                            linkedList.pollLast();
                        }
                        break;
                    case "CLEAR":
                        linkedList.clear();
                        break;
                }
            }
        }
    }

}


