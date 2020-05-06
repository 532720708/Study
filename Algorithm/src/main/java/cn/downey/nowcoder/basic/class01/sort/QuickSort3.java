package cn.downey.nowcoder.basic.class01.sort;

public class QuickSort3 {

    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;

        }
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int low, int high) {
        int i, j, pivot;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        pivot = nums[low];
        while (i < j) {
            while (pivot <= nums[j] && i < j) {
                j--;
            }
            while (pivot >= nums[i] && i < j) {
                i++;
            }
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }

        }
        nums[low] = nums[i];
        nums[i] = pivot;
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }
}
