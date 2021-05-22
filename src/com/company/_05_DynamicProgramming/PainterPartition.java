package com.company._05_DynamicProgramming;

public class PainterPartition {
    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int painters = 2;
        System.out.println(painterPartition(boards, boards.length, painters));
    }

    public static int painterPartition(int[] nums, int n, int k) {
        if (k == 1) {
            return sum(nums, 0, n - 1);
        } if (n == 1) {
            return nums[0];
        }
        int best = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            best = Math.min(best, Math.max(painterPartition(nums, i, k - 1),
                    sum(nums, i, n - 1)));
        }
        return best;
    }

   public static int sum(int[] arr, int from, int to) {
        int total = 0;
        for (int i = from; i <= to; i++) {
            total += arr[i];
        }
        return total;
    }

    public static int painterPartitionDP(int[] arr, int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = sum(arr, 0, i - 1);
        }
        for (int i = 1; i <= k; i++) {
            dp[i][1] = arr[0];
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int best = Integer.MAX_VALUE;
                for (int p = 1; p <= j; p++) {
                    best = Math.min(best, Math.max(dp[i - 1][p],
                            sum(arr, p, j - 1)));
                }
                dp[i][j] = best;
            }
        }
        return dp[k][n];
    }
}
