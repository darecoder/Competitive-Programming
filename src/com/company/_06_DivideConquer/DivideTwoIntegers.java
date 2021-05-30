package com.company._06_DivideConquer;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int n = 10, k = 3;
        System.out.println(division(10, 3));
    }

    public static int division(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        long absoluteDividend = Math.abs((long) dividend);
        long absoluteDivisor = Math.abs((long) divisor);
        long ans = divide(absoluteDividend, absoluteDivisor);
        return (int)ans*sign;
    }

    public static long divide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long sum = divisor;
        long multiple = 1;
        while ((sum+sum) <= dividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + divide(dividend - sum, divisor);
    }
}
