package com.CB.StringMatching;

public class KnuthMorris {
    public static int Max_N = 100005;
    public static int[] reset = new int[Max_N];
    public static void main(String[] args) {
        for (int i = 0; i < Max_N; i++) {
            reset[i] = -1;
        }
        String str = "AAABAABAACCABAABABBAAAB";
        String pattern = "AABA";

        System.out.print("Pattern is found at : ");
        KMPsearch(str,pattern);
    }

    public static void KMPpreprocess(String pat){
        int i = 0, j = -1;
        reset[0] = -1;
        while (i < pat.length()){
            while (j >= 0 && pat.charAt(i) != pat.charAt(j)){
                j = reset[j];
            }
            i++;
            j++;
            reset[i] = j;
        }
    }

    public static void KMPsearch(String str, String pat){
        KMPpreprocess(pat);
        int i = 0, j = 0;
        while (i < str.length()){
            while (j >= 0 && str.charAt(i) != pat.charAt(j)){
                j = reset[j];
            }
            i++;
            j++;
            if(j == pat.length()){
                System.out.print(i-j + " ");
                j = reset[j];
            }
        }
    }
}
