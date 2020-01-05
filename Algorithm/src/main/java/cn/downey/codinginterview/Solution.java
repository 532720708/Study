package cn.downey.codinginterview;

import cn.downey.leetcode.model.ListNode;

import java.util.ArrayList;

public class Solution {

    /**
     * p39
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                //TODO 注意这个判断条件，用于判断i位置上的值是否为i
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, numbers[i], i);
//                int temp = numbers[numbers[i]];
//                numbers[numbers[i]] = numbers[i];
//                numbers[i] = temp;
            }
        }
        return false;
    }

    public void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    /**
     * p44
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int cur_row = 0;
        int cur_col = array[0].length - 1;
        while (cur_row < array.length && cur_col >= 0) {
            if (array[cur_row][cur_col] < target) {
                cur_row++;
            } else if (array[cur_row][cur_col] > target) {
                cur_col--;
            } else if (array[cur_row][cur_col] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * p51
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int p1 = str.length() - 1;
        str.setLength(str.length() + count * 2);
        int p2 = str.length() - 1;
        while (p1 != p2) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }

    /**
     * p58
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode != null) {
            arrayList.addAll(printListFromTailToHead(listNode.next));
            arrayList.add(listNode.val);
        }
        return arrayList;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        StringBuffer stringBuffer = new StringBuffer("we are happy.");
        System.out.println(solution.replaceSpace(stringBuffer));
    }
}
