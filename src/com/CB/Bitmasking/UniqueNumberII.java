package com.CB.Bitmasking;

import java.util.Scanner;

public class UniqueNumberII {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        get2NonRepeatingNos(arr);
    }

    public static void get2NonRepeatingNos(int arr[])
    {
        int Xor = arr[0];
        int set_bit_no;
        int i;
        int x = 0;
        int y = 0;

        for(i = 1; i < arr.length; i++) {
            Xor ^= arr[i];
        }

        set_bit_no = Xor & ~(Xor-1);

        for(i = 0; i < arr.length; i++) {
            if ((arr[i] & set_bit_no) == 1) {
                x = x ^ arr[i];
            } else {
                y = y ^ arr[i];
            }
        }
        System.out.println(x + " " + y);
    }
}
