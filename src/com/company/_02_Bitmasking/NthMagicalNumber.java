package com.company._02_Bitmasking;

public class NthMagicalNumber {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(magicNumber(n));
    }

    private static int magicNumber(int n) {
        int place = 5, res = 0;
        while (n > 0) {
            if((n&1) == 1) {
                res = res + place;
            }
            place *= 5;
            n = n >> 1;
        }
        return res;
    }
}
