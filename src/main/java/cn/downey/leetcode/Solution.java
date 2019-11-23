package cn.downey.leetcode;


import cn.downey.leetcode.model.ListNode;

class Solution {
    ListNode listNode;
    public ListNode reverseList(ListNode head) {
        if(head.next == null){
            return listNode;
        }

        else
            return reverseList(head.next);
    }
}