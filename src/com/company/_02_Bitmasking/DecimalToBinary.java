package com.company._02_Bitmasking;

public class DecimalToBinary {
    public static void main(String[] args) {
        int n = 13;
        decToBinary(n);
    }

    public static void decToBinary(int n) {
        for (int i = 31; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
    }
}
