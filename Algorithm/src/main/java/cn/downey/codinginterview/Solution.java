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

    /**
     * p82
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (array[mid] <= array[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return array[end];
    }

    /**
     * p88
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        char[][] mtx = new char[rows][cols];
        boolean[][] marked = new boolean[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            mtx[i / cols][i % cols] = matrix[i];
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(mtx, str, marked, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] mtx, char[] str, boolean[][] marked, int pathLen, int r, int c) {
        final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int rows = mtx.length;
        int cols = mtx[0].length;
        if (pathLen == str.length) {
            return true;
        }
        //如果跑出边界
        //如果当前位置不等于寻找长度
        //如果当前位置已经被访问
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || mtx[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }
        marked[r][c] = true;
        //四个方向遍历
        for (int[] n : next) {
            if (backtracking(mtx, str, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }
        marked[r][c] = false;
        return false;
    }

    private int rows;
    private int cols;
    private int ans;

    /**
     * p92
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (rows == 0 || cols == 0) {
            return 0;
        }
        this.rows = rows;
        this.cols = cols;
        boolean[][] mark = new boolean[rows][cols];
        reach(mark, threshold, 0, 0);
        return ans;
    }

    public void reach(boolean[][] mark, int threshold, int r, int c) {
        final int[][] guide = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || mark[r][c]
                || getPositionSum(r) + getPositionSum(c) > threshold) {
            return;
        }
        if (getPositionSum(r) + getPositionSum(c) <= threshold) {
            ans++;
        }
        mark[r][c] = true;
        for (int[] n : guide) {
            reach(mark, threshold, r + n[0], c + n[1]);
        }
    }

    public int getPositionSum(int r) {
        int i = r;
        int ans = 0;
        while (i != 0) {
            ans += i % 10;
            i = i / 10;
        }
        return ans;
    }


    /**
     * p96
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
//        if (n < 2) {
//            return 0;
//        }
//        if (n == 2) {
//            return 1;
//        }
//        if (n == 3) {
//            return 2;
//        }
//        int timesOf3 = n / 3;
//        if (n - timesOf3 * 3 == 1) {
//            timesOf3--;
//        }
//        int timesOf2 = (n - timesOf3 * 3) / 2;
//        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }

    /**
     * p100
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }

    /**
     * p110
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent == -1) {
            return 1 / base;
        }
        if (exponent % 2 == 0) {
            return Power(base, exponent / 2) * Power(base, exponent / 2);
        } else {
            return exponent > 0 ? Power(base, exponent / 2) * Power(base, exponent / 2) * base :
                    Power(base, exponent / 2) * Power(base, exponent / 2) / base;
        }
    }

    /**
     * p114
     *
     * @param n
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] nums = new char[n];
        print1ToMaxOfNDigits(nums, 0);
    }

    private void print1ToMaxOfNDigits(char[] nums, int digits) {
        if (digits == nums.length) {
            printNumber(nums);
            return;
        }
        for (int i = 0; i < 10; i++) {
            nums[digits] = (char) (i + '0');
            print1ToMaxOfNDigits(nums, digits + 1);
        }
    }

    private void printNumber(char[] nums) {
        int index = 0;
        while (index < nums.length && nums[index] == '0') {
            index++;
        }
        while (index < nums.length) {
            System.out.print(nums[index++]);
        }
        System.out.println();
    }

    /**
     * TODO p122
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null && pHead.next == null) {
            return null;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    /**
     * TODO p124
     */


    /**
     * p134
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        while (node1 != null) {
            if (k != 0) {
                node1 = node1.next;
                k--;
                if (node1 == null && k != 0) {
                    return null;
                }
            } else {
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return node2;
    }

    /**
     * p139
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode nodeSlow = pHead;
        ListNode nodeFast = pHead;
        do {
            nodeSlow = nodeSlow.next;
            nodeFast = nodeFast.next.next;
        } while (nodeSlow != nodeFast);
        nodeFast = pHead;
        while (nodeSlow != nodeFast) {
            nodeSlow = nodeSlow.next;
            nodeFast = nodeFast.next;
        }
        return nodeFast;
    }

    /**
     * p142
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
//        ListNode node = new ListNode(-1);
//        while (head!= null) {
//            ListNode next = head.next;
//            head.next = node.next;
//            node.next = head;
//            head = next;
//        }
//        return node.next;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newNode = ReverseList(next);
        next.next = head;
        return newNode;
    }

    /**
     * p145
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
//        if (list1 == null)
//            return list2;
//        if (list2 == null)
//            return list1;
//        if (list1.val <= list2.val) {
//            list1.next = Merge(list1.next, list2);
//            return list1;
//        } else {
//            list2.next = Merge(list1, list2.next);
//            return list2;
//        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }

    /**
     * p148
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
