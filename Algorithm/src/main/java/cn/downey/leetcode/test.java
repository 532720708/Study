package cn.downey.leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;

public class test {
    static int[] a = new int[]{1, 8, 6, 8, 2, 9};

    public static void main(String[] args) {
        test test = new test();
//        test.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
//        test.LeftRotateString("abcdefg", 2);
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size <= 0) {
            return res;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            //队列非空并且deque的last下标不是最大值，把last出队
            while (!deque.isEmpty() && num[deque.getLast()] < num[i]) {
                deque.pollLast();
            }
            //往队列添加当前下标
            deque.addLast(i);
            //队列非空并且对头元素不在窗口内，把对头出队
            while (!deque.isEmpty() && deque.getFirst() <= i - size) {
                deque.pollFirst();
            }
            if (i >= size - 1) {
                res.add(num[deque.getFirst()]);
            }
        }
        return res;
    }

    public String LeftRotateString(String str, int n) {
        if (n > str.length() || str == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer(str);
        for (int i = 0; i < n / 2; i++) {
            swap(sb, i, n - i - 1);
        }
        System.out.println("==========");
        for (int i = n; i < (str.length() + n) / 2; i++) {
            swap(sb, i, str.length() - i + n - 1);
        }
        for (int i = 0; i < str.length() / 2; i++) {
            swap(sb, i, str.length() - i - 1);
        }
        return sb.toString();
    }

    public void swap(StringBuffer str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        System.out.println(str);
        str.setCharAt(j, temp);
        System.out.println(str);
    }
}
