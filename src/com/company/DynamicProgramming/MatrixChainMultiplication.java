package com.company.DynamicProgramming;

import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the no. of matrix : ");
        int n = s.nextInt();
        System.out.print("Enter the dimensions of the matrices : ");
        int[] dim = new int[n+1];
        for (int i = 0; i < dim.length; i++) {
            dim[i] = s.nextInt();
        }

        System.out.println("Minimum no. of multiplication : " +
                MatrixChainOrder(dim,1,dim.length-1));
    }

    public static int MatrixChainOrder(int[] p, int i, int j) {
        if (i == j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k=i; k<j; k++)
        {
            int count = MatrixChainOrder(p, i, k) +
                    MatrixChainOrder(p, k+1, j) +
                    p[i-1]*p[k]*p[j];
            if (count < min)
                min = count;
        }
        return min;
    }
}
