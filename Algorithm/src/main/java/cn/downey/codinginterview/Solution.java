package cn.downey.codinginterview;

import cn.downey.leetcode.model.ListNode;
import cn.downey.leetcode.model.TreeNode;
import cn.downey.leetcode.util.TreeConverter;

import java.util.*;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
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
            System.out.println(Arrays.toString(nums));
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
        return isSub(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean isSub(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSub(root1.right, root2.right) && isSub(root1.left, root2.left);
    }

    /**
     * p157
     *
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }

    /**
     * p159
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);

    }

    boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }

    /**
     * p171
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null) {
                    continue;
                }
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }

    /**
     * 174
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0) {
                ret.add(list);
            }
        }
        return ret;
    }

    /**
     * p176
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> PrintZ(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0) {
                if (!reverse) {
                    ret.add(list);
                    reverse = true;
                } else {
                    Collections.reverse(list);
                    ret.add(list);
                    reverse = false;
                }
            }
        }
        return ret;
    }

    /**
     * p179
     *
     * @param sequence
     * @return
     */
    public boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySequenceOfBST(int[] sequence, int start, int end) {
        if (end - start <= 1) {
            return true;
        }
        int root = sequence[end];
        int curIndex;
        for (curIndex = start; curIndex < end; curIndex++) {
            if (sequence[curIndex] > root) {
                break;
            }
        }
        for (int i = curIndex; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return VerifySequenceOfBST(sequence, 0, curIndex - 1) && VerifySequenceOfBST(sequence, curIndex, end - 1);
    }

    /**
     * p182
     *
     * @param root
     * @param target
     * @return
     */
    private ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(Integer[] integers, int target) {
        back(TreeConverter.convert(integers), target, new ArrayList<>());
        return arrayList;
    }

    private void back(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (target - root.val == 0 && root.left == null && root.right == null) {
            arrayList.add(new ArrayList<>(path));
        } else {
            back(root.left, target - root.val, path);
            back(root.right, target - root.val, path);
        }
        path.remove(path.size() - 1);
    }

    /**
     * p187
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        cur = pHead;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode cloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return cloneHead;
    }

    /**
     * p191
     *
     * @param pRootOfTree
     * @return
     */
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        if (head == null) {
            head = node;
        }
        inOrder(node.right);
    }

    /**
     * p195
     *
     * @param root
     * @return
     */
    private String deserializeStr;

    public String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    public TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0) {
            return null;
        }
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#")) {
            return null;
        }
        TreeNode t = new TreeNode(Integer.parseInt(node));
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.Deserialize("1 2 3 4 # 5 6");
    }
}
