package cn.downey.nowcoder.basic.class01.sort;

public class QuickSort2 implements Sort {

    public static void main(String[] args) {
        int[] arr = {55, 74, 13, 21, 88, 99, 44};
        quickSort(arr, 0, arr.length - 1);
    }

    @Override
    public void Sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        int i, j, pivot;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        pivot = arr[i];
        while (i < j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
        }
    }


}
