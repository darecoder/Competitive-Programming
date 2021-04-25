package com.company.FenwickTree;

import java.util.Scanner;

public class RangeSum {
    public static int[] nums = new int[10000];
    public static int[] BIT = new int[10000];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            nums[i] = s.nextInt();
            update(i,nums[i], n);
        }

        int q = s.nextInt();
        while (q-- > 0){
            int l = s.nextInt();
            int r = s.nextInt();

            System.out.println(query(r) - query(l-1));
        }
    }

    public static void update(int i, int inc, int n){
        while (i <= n){
            BIT[i] += inc;
            i += (i & (-i));
        }
    }

    public static int query(int i){
        int ans = 0;
        while (i > 0){
            ans += BIT[i];
            i -= (i & (-i));
        }

        return ans;
    }
}
