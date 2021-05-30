package com.company._06_DivideConquer;

public class Power_X_N {
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        System.out.println(myPow(x,n));
    }

    public static double myPow(double x, int n) {
        double ans = 1;
        long absVal = Math.abs((long)n);
        while(absVal > 0) {
            if((absVal & 1)==1) {
                ans *= x;
            }
            absVal >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
}
