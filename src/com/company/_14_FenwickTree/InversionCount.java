package com.company._14_FenwickTree;

import java.util.Scanner;

public class InversionCount {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int max = Integer.MIN_VALUE;
        int[] nums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            nums[i] = s.nextInt();
            max = Math.max(nums[i], max);
        }

        int[] BIT = new int[max+1];
        int ans = 0;
        for (int i = n; i >= 1; i--) {
            ans += query(nums[i] - 1, BIT);
            update(nums[i], 1, max, BIT);
        }

        System.out.println(ans);
    }

    public static void update(int i, int inc, int n, int[] BIT){
        while (i <= n){
            BIT[i] += inc;
            i += (i & (-i));
        }
    }

    public static int query(int i, int[] BIT){
        int ans = 0;
        while (i > 0){
            ans += BIT[i];
            i -= (i & (-i));
        }

        return ans;
    }
}
