package com.company.Bitmasking;

import java.util.Scanner;

public class AdvancedNQueens {
    public static int DONE;
    public static int[][] board = new int[20][20];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        DONE = ((1<<n) - 1);

        int ans = 0;
        ans = solve(0,0,0, ans, 0,n);
        System.out.println(ans);

    }

    public static int getPos(int n){
        int ans = 0;
        while (n > 0){
            ans++;
            n = n >> 1;
        }
        return ans-1;
    }
    public static int solve(int rowMask, int left_diag, int right_diag, int ans, int row, int n){
        if(rowMask == DONE){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            ans++;
            return ans;
        }

        int safe = DONE & (~(rowMask|left_diag|right_diag));
        while (safe > 0){
            int p = safe & (-safe);
            // p will provide column
            int col = getPos(p);
            board[row][col] = 1;
            safe = safe - p;
            ans = solve(rowMask|p, (left_diag|p) << 1,
                    (right_diag|p) >> 1, ans, row + 1,n);
            board[row][col] = 0;
        }
        return ans;
    }
}
