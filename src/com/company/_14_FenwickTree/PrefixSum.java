package com.company._14_FenwickTree;

import java.util.Scanner;

public class PrefixSum {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        int[] BIT = new int[n+1];

        for (int i = 1; i <= n; i++) {
            nums[i] = s.nextInt();
            update(i,nums[i], n, BIT);
        }

        int q = s.nextInt();
        System.out.println(query(q, BIT));
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
