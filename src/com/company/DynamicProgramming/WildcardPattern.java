package com.company.DynamicProgramming;

public class WildcardPattern {
    /* Given a text and a wildcard pattern, implement wildcard pattern matching
    algorithm that finds if wildcard pattern is matched with text. The matching
    should cover the entire text (not partial text).
    The wildcard pattern can include the characters ‘?’ and ‘*’
    ‘?’ – matches any single character
    ‘*’ – Matches any sequence of characters (including the empty sequence) */

    public static void main(String[] args) {
        String str = "baaabab";
        String pattern = "*****ba*****ab";
        // String pattern = "ba*****ab";
        // String pattern = "ba*ab";
        // String pattern = "a*ab";

        System.out.println(stringMatch(str, pattern));
    }
    public static boolean stringMatch(String str, String pattern) {
        if (pattern.length() == 0) {
            return (str.length() == 0);
        }
        boolean[][] mem = new boolean[str.length() + 1][pattern.length() + 1];
        mem[0][0] = true;
        for (int j = 1; j <= pattern.length(); j++) {
            if (pattern.charAt(j - 1) == '*') {
                mem[0][j] = mem[0][j - 1];
            }
        }
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (pattern.charAt(j - 1) == '*') {
                    mem[i][j] = mem[i][j - 1] || mem[i - 1][j];
                } else if (pattern.charAt(j - 1) == '?'
                        || str.charAt(i - 1) == pattern.charAt(j - 1)) {
                    mem[i][j] = mem[i - 1][j - 1];
                } else {
                    mem[i][j] = false;
                }
            }
        }
        return mem[str.length()][pattern.length()];
    }
}
