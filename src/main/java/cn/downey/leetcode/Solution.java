package cn.downey.leetcode;


import cn.downey.leetcode.model.ListNode;
import cn.downey.leetcode.model.TreeNode;

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

}