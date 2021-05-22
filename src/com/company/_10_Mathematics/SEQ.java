package com.company._10_Mathematics;

import java.util.Scanner;

public class SEQ {
    public static long MOD = 1000000000;
    public static int k;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0){
            k = s.nextInt();
            long[] b = new long[k];
            long[] c = new long[k];

            for (int i = 0; i < k; i++) {
                b[i] = s.nextLong();
            }
            for (int i = 0; i < k; i++) {
                c[i] = s.nextLong();
            }

            int n = s.nextInt();
            System.out.println(compute(n,b,c));
        }
    }

    public static long compute(int n, long[] b, long[] c){
        if (n == 0){
            return 0;
        }
        if(n <= k){
            return b[n-1];
        }
        //Matrix Exponentiation
        long[] f1 = new long[k+1];
        for (int i = 1; i <= k; i++) {
            f1[i] = b[i - 1];
        }

        long[][] T = new long[k+1][k+1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                if(i < k){
                    if (j == i+1){
                        T[i][j] = 1;
                    }else {
                        T[i][j] = 0;
                    }
                    continue;
                }
                T[i][j] = c[k-j];
            }
        }

        T = power(T,n-1);

        long res  = 0;
        for (int i = 1; i <= k; i++) {
            res = (res + (T[1][i] * f1[i]) % MOD) % MOD;
        }
        return res;
    }

    public static long[][] power(long[][] T, int p){
        if(p == 1){
            return T;
        }

        long[][] X = power(T,p/2);
        X = multiply(X,X);
        if((p & 1) == 1){
            return multiply(T,X);
        }else {
            return X;
        }
    }

    public static long[][] multiply(long[][] A, long[][] B){
        long[][] C = new long[k+1][k+1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 1; l <= k; l++) {
                    C[i][j] = (C[i][j] + (A[i][l] * B[l][j]) % MOD) % MOD;
                }
            }
        }
        return C;
    }
}
