package cn.downey.nowcoder.basic.class01.sort;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 排序对数器
 */
public class SortUtil {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
//            threadPool.execute(() -> check(new SelectionSort()));
//            threadPool.execute(() -> check(new BubbleSort()));
//            threadPool.execute(() -> check(new InsertionSort()));
//            threadPool.execute(() -> check(new MergeSort()));
//            threadPool.execute(() -> check(new QuickSort()));
//            threadPool.execute(() -> check(new RadixSort()));
//            threadPool.execute(() -> check(new QuickSort2()));
            threadPool.execute(() -> check(new HeapSort()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void check(Sort sort) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            sort.Sort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println(sort.getClass().getName());
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? Thread.currentThread().getName() + "\tNice!" : Thread.currentThread().getName() + "\tOops!");
    }
}
