package com.company._10_Mathematics;

import java.util.Scanner;

public class FastExponentiation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();

        System.out.println(power(x,n));
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }

        int smallerAns = power(x, n/2);
        smallerAns *= smallerAns;

        if ((n & 1) == 1){
            smallerAns *= x;
        }

        return smallerAns;
    }
}
