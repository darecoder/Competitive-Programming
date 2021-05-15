package com.company.Bitmasking;

import java.util.Scanner;

public class NQueensBitsets {
    public static boolean[] col = new boolean[30];
    public static boolean[] d1 = new boolean[30];
    public static boolean[] d2 = new boolean[30];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ans = 0;
        ans = solve(0,n,ans);
        System.out.println(ans);
    }

    public static int solve(int r, int n, int ans){
        if(r == n){
            return ans+1;
        }
        for (int c = 0; c < n; c++) {
            if(!col[c] && !d1[r-c+n-1] && !d2[r+c]){
                col[c] = d1[r-c+n-1] = d2[r+c] = true;
                ans = solve(r+1,n,ans);
                col[c] = d1[r-c+n-1] = d2[r+c] = false;
            }
        }
        return ans;
    }
}
