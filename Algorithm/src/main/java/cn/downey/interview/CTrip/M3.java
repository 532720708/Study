package cn.downey.interview.CTrip;

import java.util.Scanner;


class Job {
    int start;
    int end;
    int cost;

    Job(int start, int end) {
        this.start = start;
        this.end = end;
        this.cost = start - cost;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getCost() {
        return cost;
    }
}

public class M3 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int calcMinStaff(int start, int[] dp, Job[] jobs) {
        if (start == dp.length - 1) {
            return 0;
        }
        int need = 1;
        for (int i = 1; i < jobs.length; i++) {
            if (jobs[i - 1].end > jobs[i].start) {
                dp[i] = Math.min(calcMinStaff(i + 1, dp, jobs), dp[i - 1] + 1);
                need += dp[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return need;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int n = Integer.parseInt(in.nextLine());
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            jobs[i] = new Job(Integer.parseInt(str.split(",")[0]),
                    Integer.parseInt(str.split(",")[1]));
        }
        int[] dp = new int[jobs.length];
        dp[0] = 0;
        res = calcMinStaff(0, dp, jobs);
        System.out.println(String.valueOf(res));

    }
}
