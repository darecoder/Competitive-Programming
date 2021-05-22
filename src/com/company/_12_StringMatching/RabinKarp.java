package com.company._12_StringMatching;

public class RabinKarp {
    public static int prime = 119;

    public static void main(String[] args) {
        String str = "AAABAABAACCABAABABBAAAB";
        String pattern = "AABA";

        long patHash = createHashValue(pattern, pattern.length());
        long strHash = createHashValue(str, pattern.length());

        System.out.print("Pattern is found at : ");

        for (int i = 0; i <= str.length() - pattern.length(); i++) {
            if(patHash == strHash &&
            checkEqual(str, pattern, i,i+pattern.length()-1,0,pattern.length()-1)){
                System.out.print(i + " ");
            }
            if(i < str.length()-pattern.length()){
                strHash = recalculateHash(str,i,i+pattern.length(),strHash,pattern.length());
            }
        }
    }

    public static long createHashValue(String str, int n){
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long)(str.charAt(i)*(long)Math.pow(prime, i));
        }
        return result;
    }

    public static long recalculateHash(String str, int oldInd, int newInd, long oldHash, int patlength){
        long newHash = oldHash - str.charAt(oldInd);
        newHash /= prime;
        newHash += (long)(str.charAt(newInd)*(long)(Math.pow(prime,patlength-1)));
        return newHash;
    }

    public static boolean checkEqual(String s1, String s2, int start1, int end1, int start2, int end2){
        if(end1 - start1 != end2 - start2){
            return false;
        }
        while (start1 <= end1 && start2 <= end2){
            if(s1.charAt(start1) != s2.charAt(start2)){
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }
}
