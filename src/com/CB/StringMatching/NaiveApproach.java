package com.CB.StringMatching;

import java.util.Scanner;

public class NaiveApproach {
    public static void main(String[] args) {
        String str = "AAABAABAACCABAABABBAAAB";
        String pattern = "AABA";

        System.out.print("Pattern is found at : ");
        countOccur(str, pattern);
    }

    private static void countOccur(String str, String pattern) {
        for (int i = 0; i <= str.length() - pattern.length(); i++) {
            int j;
            for (j = 0; j < pattern.length(); j++) {
                if(str.charAt(i+j) != pattern.charAt(j)){
                    break;
                }
            }
            if(j == pattern.length()){
                System.out.print(i + " ");
            }
        }
    }
}
