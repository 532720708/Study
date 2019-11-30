package cn.downey.leetcode;


import cn.downey.leetcode.model.ListNode;
import cn.downey.leetcode.model.TreeNode;

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        else{
            return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
        }
    }


}