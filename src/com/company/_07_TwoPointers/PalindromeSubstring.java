package com.company._07_TwoPointers;

public class PalindromeSubstring {
    public static void main(String[] args) {
        String str = "abba";
        System.out.println(countPalindrome(str));
    }

    private static int countPalindrome(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            //check for odd length
            int left = i, right = i;
            while (left >= 0 && right < str.length()) {
                if (str.charAt(left--) == str.charAt(right++)) {
                    count++;
                } else {
                    break;
                }
            }
            //check for even length
            left = i; right = i+1;
            while (left >= 0 && right < str.length()) {
                if (str.charAt(left--) == str.charAt(right++)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
