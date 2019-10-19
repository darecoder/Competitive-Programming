package com.CB.Recursion;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        System.out.println(fibo(n));
    }

    public static int fibo(int n) {
        if (n < 2){
            return n;
        }

        int f1 = fibo(n-1);
        int f2 = fibo(n-2);

        return f1 + f2;
    }
}
