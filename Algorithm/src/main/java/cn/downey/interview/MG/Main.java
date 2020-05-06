package cn.downey.interview.MG;

import java.util.List;

public class Main {
    public static long getIdealNums(long low, long high) {
        int ans = 0;
        int lowA = 0;
        int highA = 0;
        while (Math.pow(5, lowA) < low) {
            lowA++;
        }
        while (Math.pow(3, highA) < high) {
            highA++;
        }
        for (int i = 0; i <= lowA || i <= highA; i++) {
            for (int j = 0; j <= lowA || j <= highA; j++) {
                double v = Math.pow(3, i) * Math.pow(5, j);
                if (v <= high
                        && (v >= low)) {
                    ans++;
                }
            }
        }
        return ans;

    }

    public static long maxInversions(List<Integer> arr) {
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    for (int k = j + 1; k < arr.size(); k++) {
                        if (arr.get(j) > arr.get(k)) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

//    public static long maxInversions(List<Integer> arr) {
//        Collections.reverse(arr);
//        int[] dp = new int[arr.size()];
//        int ans = 0;
//        dp[0] = 0;
//        for (int i = 1; i < arr.size(); i++) {
//            for (int j = 0; j < i; j++) {
//                if (arr.get(i) > arr.get(j)) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//                if (dp[i] > 1) {
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }

//    public static long maxInversions(List<Integer> arr) {
//        List<List<Integer>> res = new ArrayList<>();
//        int[] nums = new int[arr.size()];
//        for (int i = 0; i < arr.size(); i++) {
//            nums[i] = arr.get(i);
//        }
//        dfs(res, new ArrayList<>(), nums, 0);
//        return res.size();
//    }
//
//    private static void dfs(List<List<Integer>> res, List<Integer> sub, int[] nums, int cur) {
//        if (sub.size() == 3) {
//            res.add(new ArrayList<>(sub));
//        } else {
//            Set<Integer> set = new HashSet<>();
//            for (int i = cur; i < nums.length; i++) {
//                if (set.contains(nums[i])) {
//                    continue;
//                }
//                if (sub.size() == 0 || nums[i] < sub.get(sub.size() - 1)) {
//                    set.add(nums[i]);
//                    sub.add(nums[i]);
//                    dfs(res, sub, nums, i + 1);
//                    sub.remove(sub.size() - 1);
//                }
//            }
//        }
//
//    }
}
