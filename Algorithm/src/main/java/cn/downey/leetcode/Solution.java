package cn.downey.leetcode;


import cn.downey.leetcode.model.ListNode;
import cn.downey.leetcode.model.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

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
            ans += ((int) s.charAt(i) - 64) * Math.pow(26, s.length() - i - 1);
        }
        return ans;
    }

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
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
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

    public List<Integer> sortArray(int[] nums) {
        Arrays.sort(nums);
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    public double area(int[] p, int[] q, int[] r) {
        return 0.5 * Math.abs(p[0] * q[1] + q[0] * r[1] + r[0] * p[1]
                - p[1] * q[0] - q[1] * r[0] - r[1] * p[0]);
    }

    public int numberOfBoomerangs(int[][] points) {
        if (points.length < 3) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    ans += distance(points[i], points[j], points[k]);
                }
            }
        }
        return ans * 2;
    }

    public int distance(int[] p, int[] q, int[] r) {
        int ans = 0;
        double a = Math.pow(p[1] - q[1], 2) + Math.pow(p[0] - q[0], 2);
        double b = Math.pow(p[1] - r[1], 2) + Math.pow(p[0] - r[0], 2);
        double c = Math.pow(q[1] - r[1], 2) + Math.pow(q[0] - r[0], 2);
        if (a == b) {
            ans++;
        }
        if (a == c) {
            ans++;
        }
        if (b == c) {
            ans++;
        }
        return ans;
    }

    public boolean isPerfectSquare(int num) {
        if (1 == num) {
            return true;
        }
        int i = num / 2;
        while ((double) i * i > num) {
            i = (i + num / i) / 2;
        }
        return i * i == num;
    }

    public String[] uncommonFromSentences(String A, String B) {
        String[] str = (A + " " + B).split(" ");
        Set<String> set = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for (String s : str) {
            if (set.contains(s)) {
                ans.remove(s);
            } else {
                ans.add(s);
                set.add(s);
            }
        }
        return ans.toArray(new String[0]);
    }

    public int findSpecialInteger(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
                if (count >= arr.length * 0.25) {
                    return arr[i];
                }
            } else {
                count = 0;
            }
        }
        return arr[0];
    }

    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }

    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int n = grid[i][j];
                if (n > 0) {
                    area += n * 4 + 2;
                    area -= i > 0 ? Math.min(n, grid[i - 1][j]) / 2 : 0;
                    area -= j > 0 ? Math.min(n, grid[i][j - 1]) / 2 : 0;
                }
            }
        }
        return area;
    }

    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                //需要把path清空，用于递归
                path.remove(path.size() - 1);
            }
        }
    }


    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return null;
        }
        List<List<String>> res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(res, board, 0);
        return res;
    }

    /**
     * 路径：board中小于row的那些行都已经成功放置了皇后
     * 可选择列表: 第row行的所有列都是放置Q的选择
     * 结束条件: row超过board的最后一行
     *
     * @param board
     * @param row
     */
    private void backtrack(List<List<String>> res, char[][] board, int row) {
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(res, board, row + 1);
            board[row][col] = '.';
        }
    }

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    private boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public int trap(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[set.size()];
        List<Integer> temp = new ArrayList<>();
        int length = 0;
        int pos = 0;
        int tempSum = 0;
        threeSumDFS(ans, temp, set.toArray(new Integer[0]), visited, length, pos, tempSum);
        return ans;
    }

    private void threeSumDFS(List<List<Integer>> ans, List<Integer> temp, Integer[] nums, boolean[] visited, int length, int pos, int tempSum) {
        System.out.println(temp);
        if (length == 3 && tempSum == 0) {
            ans.add(new ArrayList<>(temp));
        }
        if (length > 3) {
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            visited[i] = true;
            temp.add(nums[i]);
            threeSumDFS(ans, temp, nums, visited, length + 1, i + 1, tempSum + nums[i]);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public String alienOrder(String[] words) {
        //1.构建图
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                //如果字符相同，比较下一个
                if (words[i].charAt(j) == words[i + 1].charAt(j)) {
                    continue;
                }
                //保存第一个不同的字符顺序
                Set<Character> set = map.getOrDefault(words[i].charAt(j), new HashSet<>());
                set.add(words[i + 1].charAt(j));
                map.put(words[i].charAt(j), set);
                break;
            }
        }

        //2.拓扑排序
        //创建保存入度的数组
        int[] degrees = new int[26];
        Arrays.fill(degrees, -1);
        //注意，不是26字母都在words中出现，所以出度分为两种情况：没有出现的字母出度为-1，出现了的字母的出度为非负数
        for (String str : words) {
            //将出现过的字符的出度设定为0
            for (char c : str.toCharArray()) {
                degrees[c - 'a'] = 0;
            }
        }
        for (char key : map.keySet()) {
            for (char val : map.get(key)) {
                degrees[val - 'a']++;
            }
        }
        //创建StringBuilder保存拓扑排序
        StringBuilder sb = new StringBuilder();
        //创建一个Queue保存入度为0的节点
        Queue<Character> list = new LinkedList<>();

        int count = 0;//计算图中节点数
        for (int i = 0; i < 26; i++) {
            if (degrees[i] != -1) {
                count++;
            }
            if (degrees[i] == 0) {
                list.add((char) ('a' + i));
            }
        }

        while (!list.isEmpty()) {
            Character cur = list.poll();
            sb.append(cur);
            //将邻接点出度-1
            if (map.containsKey(cur)) {
                Set<Character> set = map.get(cur);
                for (Character c : set) {
                    degrees[c - 'a']--;
                    if (degrees[c - 'a'] == 0) {
                        list.add(c);
                    }
                }
            }
        }

        //判断是否有环
        if (sb.length() != count) {
            return "";
        } else {
            return sb.toString();
        }

    }

    //鸡蛋
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int ans = 0;    // 操作的次数
        while (dp[K] < N) {
            for (int i = K; i > 0; i--) // 从后往前计算
            {
                dp[i] = dp[i] + dp[i - 1] + 1;
                System.out.println("i:" + i + "====" + Arrays.toString(dp));
            }
            System.out.println("*******************");
            ans++;
        }
        return ans;
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[len1][len2];
    }


    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        int ans = nums[0];
        System.arraycopy(nums, 0, dp, 1, len);
        for (int i = 1; i <= len; i++) {
            dp[i] = Math.max(dp[i] * dp[i - 1], dp[i]);
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }

    //最长等差数列
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int[][] dp = new int[A.length][20001];
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int distance = A[i] - A[j] + 10000;
                if (dp[j][distance] > 0) {
                    dp[i][distance] = Math.max(dp[i][distance], dp[j][distance] + 1);
                } else {
                    dp[i][distance] = 2;
                }
                max = Math.max(max, dp[i][distance]);
            }
        }
        return max;
    }

    //回文子数组
    public int minimumMoves(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            } else {
                dp[i][i + 1] = 2;
            }
        }
        for (int len = 2; len < arr.length; len++) {
            for (int i = 0; i < arr.length - len; i++) {
                dp[i][i + len] = len + 1;
                for (int k = 0; k < len; k++) {
                    if (dp[i][i + len] > dp[i][i + k] + dp[i + k + 1][i + len]) {
                        dp[i][i + len] = dp[i][i + k] + dp[i + k + 1][i + len];
                    }
                }
                if (arr[i] == arr[i + len] && dp[i][i + len] > dp[i + 1][i + len - 1]) {
                    dp[i][i + len] = dp[i + 1][i + len - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][arr.length - 1];
    }

    public int[] maxDepthAfterSplit(String seq) {
        int d = 0;
        int[] ans = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                d++;
                ans[i] = d % 2;
            } else {
                ans[i] = d % 2;
                d--;
            }
        }
        return ans;

    }

    int res = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //如果当前节点没有子节点，则直接返回
        helper(root, root.val, root.val);
        return res;
    }

    /**
     * 每条从根节点到叶子节点的路径中的最大值和最小值，并求出差值更新全局变量
     */
    private void helper(TreeNode node, int max, int min) {
        if (node == null) {
            return;
        }
        max = Math.max(node.val, max);
        min = Math.min(node.val, min);
        //到达叶子节点，求最大差值
        if (node.left == null && node.right == null) {
            res = Math.max(res, Math.abs(max - min));
        }
        helper(node.left, max, min);
        helper(node.right, max, min);
    }

    //子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    //最小因式分解
    public int smallestFactorization(int a) {
        if (a <= 9) {
            return a;
        }
        long ans = 0;
        long pos = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                ans = ans + i * pos;
                pos *= 10;
                if (ans > Integer.MAX_VALUE) {
                    return 0;
                }
                a /= i;
            }
        }
        if (a != 1) {
            return 0;
        }
        return (int) ans;

    }

    //将数组分割成相等的子数组
    public boolean splitArray(int[] nums) {
        if (nums.length < 7) {
            return false;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int j = 3; j < nums.length - 3; j++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i]) {
                    set.add(sum[i - 1]);
                }
            }
            for (int k = j + 2; k < nums.length - 1; k++) {
                if (sum[nums.length - 1] - sum[k] == sum[k - 1] - sum[j] && set.contains(sum[k - 1] - sum[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    //凸多边形
    public boolean isConvex(List<List<Integer>> points) {
        long dx1 = points.get(1).get(0) - points.get(0).get(0);
        long dy1 = points.get(1).get(1) - points.get(0).get(1);
        long dx2 = 0, dy2 = 0;

        points.add(points.get(0));
        points.add(points.get(1));
        long prev_val = 0;
        long out_mul = 0;
        for (int i = 1; i < points.size(); i++) {
            dx2 = points.get(i).get(0) - points.get(i - 1).get(0);
            dy2 = points.get(i).get(1) - points.get(i - 1).get(1);
            out_mul = dx1 * dy2 - dx2 * dy1;

            if (prev_val * out_mul < 0) {
                return false;
            }

            if (out_mul != 0) {
                prev_val = out_mul;
            }

            dx1 = dx2;
            dy1 = dy2;
        }

        return true;
    }

    //气球、射击
    public int maxCoins(int[] nums) {
        //避免空指针异常
        if (nums == null) {
            return 0;
        }

        //创建虚拟边界
        int length = nums.length;
        int[] nums2 = new int[length + 2];
        System.arraycopy(nums, 0, nums2, 1, length);
        nums2[0] = 1;
        nums2[length + 1] = 1;
        length = nums2.length;

        //创建dp表
        length = nums2.length;
        int[][] dp = new int[length][length];

        //开始dp：i为begin，j为end，k为在i、j区间划分子问题时的边界
        for (int i = length - 2; i > -1; i--) {
            for (int j = i + 2; j < length; j++) {
                //维护一个最大值；如果i、j相邻，值为0
                int max = 0;
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(max, dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j]);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][length - 1];
    }

    //最长回文字串
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public String validIPAddress(String IP) {
        if (IP.startsWith(":") || IP.startsWith(".")
                || IP.endsWith(":") || IP.endsWith(".")) {
            return "Neither";
        }
        String[] splitted = IP.split("\\.");
        if (splitted.length == 4) {
            int num = -1;
            for (int i = 0; i < 4; i++) {
                try {
                    num = Integer.parseInt(splitted[i]);
                } catch (NumberFormatException e) {
                    return "Neither";
                }
                if (num < 0 || num > 255) {
                    return "Neither";
                }
                if (splitted[i].length() > 1
                        && (splitted[i].startsWith("0") || splitted[i].startsWith("-"))) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            splitted = IP.split(":");
            if (splitted.length == 8) {
                long num = -1;
                for (int i = 0; i < 8; i++) {
                    if (splitted[i].length() > 4 || splitted[i].startsWith("-")) {
                        return "Neither";
                    }
                    try {
                        num = Long.parseLong(splitted[i], 16);
                    } catch (NumberFormatException e) {
                        return "Neither";
                    }
                    if (num < 0) {
                        return "Neither";
                    }
                }
                return "IPv6";
            } else {
                return "Neither";
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, area(grid, i, j));
                }
            }
        }
        return res;

    }

    private int area(int[][] grid, int r, int c) {
        if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return 1 +
                area(grid, r - 1, c) +
                area(grid, r + 1, c) +
                area(grid, r, c - 1) +
                area(grid, r, c + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }


}