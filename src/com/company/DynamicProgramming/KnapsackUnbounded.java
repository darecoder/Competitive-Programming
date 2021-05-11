package com.company.DynamicProgramming;

public class KnapsackUnbounded {
    public static void main(String[] args) {
        int capacity = 100;
        int[] profit = {10, 30, 20};
        int[] weights = {5, 10, 15};
        System.out.println(knapsackUnbounded(capacity, weights, profit));
    }
    public static int knapsackUnbounded(int cap, int[] weights, int[] profits) {
        int[] dp = new int[cap+1];

        for (int i = 1; i <= cap; i++){
            for (int j = 0; j < profits.length; j++) {
                if (weights[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - weights[j]] + profits[j]);
                }
            }
        }

        return dp[cap];
    }
}
