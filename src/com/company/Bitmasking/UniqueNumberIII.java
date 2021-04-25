package com.company.Bitmasking;

import java.util.Scanner;

public class UniqueNumberIII {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }
        System.out.println();

        int[] arr = new int[32];
        for (int i = 0; i < n; i++) {
            int[] arr2 = bitset(nums[i]);
            for (int j = 0; j < 32; j++) {
                arr[j] += arr2[j];
            }
        }

        int number = 0;
        for (int i = 0; i < 32; i++) {
            arr[i] = arr[i] % 3;
            number = number + (int)(arr[i] * Math.pow(2,31 - i));
        }
        System.out.println(number);
    }

    public static int[] bitset(int num) {
        String str = Integer.toBinaryString(num);
        int[] arr = new int[32];
        int cnt = str.length()-1;
        for (int i = 31; i >= 32 - str.length(); i--) {
            arr[i] = (int)(str.charAt(cnt)) - 48;
            cnt--;
        }
        return arr;
    }
}
