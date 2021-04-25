package com.company.FenwickTree;

import java.util.Scanner;

public class InversionCount {
    public static int[] BIT = new int[10000];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] nums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            nums[i] = s.nextInt();
        }

        int ans = 0;
        for (int i = n; i >= 1; i--) {
            ans += query(nums[i] - 1);
            update(nums[i], 1, n);
        }

        System.out.println(ans);
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
