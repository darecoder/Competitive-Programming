package com.company._04_Backtracking;

public class TheKnightTour {
    public static void main(String[] args) {
        int[][] sol = new int[8][8];
        for (int x = 0; x < sol.length; x++) {     //initially set all values to -1 of solution matrix
            for (int y = 0; y < sol.length; y++) {
                sol[x][y] = -1;
            }
        }
        int[] xMove = {  2, 1, -1, -2, -2, -1,  1,  2 };
        int[] yMove = {  1, 2,  2,  1, -1, -2, -2, -1 };
        sol[0][0]  = 0;     //starting from room (0, 0)

        if (!knightTour(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
        } else {
            displaySolution(sol);
        }
    }

    public static boolean knightTour(int x, int y, int move,
                                     int[][] sol, int[] xMove, int[] yMove) {
        int xNext, yNext;
        if (move == sol.length*sol.length)     //when the total board is covered
            return true;

        for (int k = 0; k < 8; k++) {
            xNext = x + xMove[k]; yNext = y + yMove[k];
            if (isValid(xNext, yNext, sol)) {     //check room is preoccupied or not
                sol[xNext][yNext] = move;
                if (knightTour(xNext, yNext,
                        move+1, sol, xMove, yMove)) {
                    return true;
                } else {
                    sol[xNext][yNext] = -1;// backtracking
                }
            }
        }
        return false;
    }

    public static boolean isValid(int x, int y, int[][] sol) {     //check place is in range and not assigned yet
        return ( x >= 0 && x < sol.length &&
                y >= 0 && y < sol.length && sol[x][y] == -1);
    }

    public static void displaySolution(int[][] sol) {
        for (int[] ints : sol) {
            for (int y = 0; y < sol.length; y++)
                System.out.print(ints[y] + " ");
            System.out.println();
        }
    }
}
