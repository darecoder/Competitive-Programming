package com.company._03_Recursion;

public class LongPalindromeSubseq {
    public static void main(String[] args) {
        String str = "abcaeaa";
        System.out.println(longPalindromeSubseq(str, 0, str.length()-1));
    }

    private static int longPalindromeSubseq(String str, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        int len = 0;
        if (str.charAt(start) == str.charAt(end)) {
            len = 2 + longPalindromeSubseq(str, start+1,end-1);
        } else {
            len = Math.max(longPalindromeSubseq(str, start+1, end),
                    longPalindromeSubseq(str, start, end-1));
        }
        return len;
    }
}
