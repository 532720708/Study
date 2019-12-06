package cn.downey.leetcode;


import cn.downey.leetcode.model.ListNode;
import cn.downey.leetcode.model.TreeNode;

class Solution {
    ListNode listNode;

    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return listNode;
        } else {
            return reverseList(head.next);
        }
    }

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
        int mid = (start + end) >>> 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = singleBST(nums, start, mid);
        root.right = singleBST(nums, mid + 1, end);
        return root;
    }
}