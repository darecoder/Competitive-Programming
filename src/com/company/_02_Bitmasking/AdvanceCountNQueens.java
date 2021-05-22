package com.company._02_Bitmasking;

import java.util.Scanner;

public class AdvanceCountNQueens {
    public static int DONE;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        DONE = ((1<<n) - 1);
        int ans = 0;
        ans = solve(0,0,0, ans, 0);
        System.out.println(ans);
    }

    public static int solve(int rowMask, int left_diag, int right_diag, int ans, int row){
        if(rowMask == DONE){
            ans++;
            return ans;
        }

        int safe = DONE & (~(rowMask|left_diag|right_diag));
        while (safe > 0){
            int p = safe & (-safe);
            // p will provide column
            safe = safe - p;
            ans = solve(rowMask|p, (left_diag|p) << 1,
                    (right_diag|p) >> 1, ans, row + 1);
        }
        return ans;
    }
}
