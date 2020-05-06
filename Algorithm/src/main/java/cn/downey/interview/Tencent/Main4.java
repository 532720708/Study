package cn.downey.interview.Tencent;

import java.util.Scanner;
import java.util.Stack;

public class Main4 {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] str = scanner.nextLine().split(" ");
            if (str[0].equals("add")) {
                add(Integer.parseInt(str[1]));
            } else if (str[0].equals("peek")) {
                System.out.println(peek());
            } else if (str[0].equals("poll")) {
                poll();
            }
        }
    }

    public static void add(int node) {
        stack1.push(node);
    }

    public static int poll() {
        if (stack2.size() == 0) {
            while (!stack1.empty()) {
                int temp = stack1.peek();
                stack2.push(temp);
                stack1.pop();
            }
        }
        int res = stack2.peek();
        stack2.pop();
        return res;
    }

    public static int peek() {
        if (stack2.size() == 0) {
            while (!stack1.empty()) {
                int temp = stack1.peek();
                stack2.push(temp);
                stack1.pop();
            }
        }
        return stack2.peek();
    }
}
