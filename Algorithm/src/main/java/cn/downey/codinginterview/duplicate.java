package cn.downey.codinginterview;

/**
 * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
 */
public class duplicate {

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
}
