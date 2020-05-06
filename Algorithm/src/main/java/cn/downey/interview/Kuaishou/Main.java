package cn.downey.interview.Kuaishou;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(func(str.toCharArray()));
    }

    private static String func(char[] chars) {
        int pairs = 0;
        int leftCount = 0;
        int rightCount = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '[' || c == '(') {
                stack.push(c);
                leftCount++;
            }
            if (c == ']') {
                if (stack.empty()) {
                    rightCount++;
                } else if (stack.peek() == '[') {
                    stack.pop();
                    pairs++;
                    leftCount--;
                } else {
                    rightCount++;
                }
            }
            if (c == ')') {
                if (stack.empty()) {
                    rightCount++;
                } else if (stack.peek() == '(') {
                    stack.pop();
                    pairs++;
                    leftCount--;
                } else {
                    rightCount++;
                }
            }
        }
        return pairs + " " + leftCount + " " + rightCount;
    }
}
