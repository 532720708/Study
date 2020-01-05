package cn.downey.codinginterview;

import cn.downey.leetcode.model.ListNode;
import cn.downey.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

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
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int p1 = str.length() - 1;
        str.setLength(str.length() + count * 2);
        int p2 = str.length() - 1;
        while (p1 != p2) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }

    /**
     * p58
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode != null) {
            arrayList.addAll(printListFromTailToHead(listNode.next));
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    /**
     * p62
     */
    private HashMap<Integer, Integer> indexForInOrders = new HashMap<>();

    /**
     * 缓存中序遍历数组每个值对应的索引
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     * @param pre  前序遍历的数组
     * @param preL
     * @param preR
     * @param inL
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        System.out.println(preL + "===" + preR + "===" + inL);
        if (preL > preR) {
            return null;
        }
        //生成一个新的根
        TreeNode root = new TreeNode(pre[preL]);
        //获取中序的索引
        int inIndex = indexForInOrders.get(root.val);
        //左子树范围
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    /**
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }


    /**
     * p69
     * 用两个栈实现队列
     */
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        //TODO out如果空 才把in的元素放到out里
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        if (out.empty()) {
            throw new Exception();
        }
        return out.pop();
    }

    /**
     * p75
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int fib0 = 0;
        int fib1 = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = fib0 + fib1;
            fib0 = fib1;
            fib1 = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Fibonacci(10));
    }
}
