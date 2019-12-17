package cn.downey.leetcode;


import cn.downey.leetcode.model.ListNode;
import cn.downey.leetcode.model.TreeNode;

import java.util.Arrays;

class Solution {
    ListNode listNode;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        }
    }

    public int hammingDistance(int x, int y) {
        int ans = 0;
        while (x != 0 || y != 0) {
            if ((x % 2 != y % 2)) {
                ans++;
            }
            x = x / 2;
            y = y / 2;

        }
        return ans;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return singleBST(nums, 0, nums.length);
    }

    public TreeNode singleBST(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int middle = (end - start) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = singleBST(nums, start, middle);
        root.right = singleBST(nums, middle + 1, end);
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += (Integer.valueOf(s.charAt(i)) - 64) * Math.pow(26, s.length() - i - 1);
        }
        return ans;
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        String a = Integer.toBinaryString(n);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1') {
                ans++;
            }
        }
        return ans;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public int fib(int N) {
        int fib0 = 0;
        int fib1 = 1;
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = fib0 + fib1;
            fib1 = fib0;
            fib0 = ans;

        }
        return ans;
    }

    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] ans = new int[N];
        int[][] matrix = new int[N][N];
        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
        }

        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - k + 1) {
                break;
            }
            int[] temp = new int[k];
            System.arraycopy(nums, i, temp, 0, k);
            Arrays.sort(temp);
            ans[i] = temp[k - 1];
        }
        return ans;

    }
}