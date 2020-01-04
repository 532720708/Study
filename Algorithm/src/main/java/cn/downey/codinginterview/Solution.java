package cn.downey.codinginterview;

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
        String ans = "";
        return ans;
    }

    public static void main(String[] args) {
        String str = "abc ab";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i) == ' ');
        }
    }
}
