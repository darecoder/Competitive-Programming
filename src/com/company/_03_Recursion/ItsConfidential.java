package com.company._03_Recursion;

public class ItsConfidential {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(decrypt(str));
    }

    public static String decrypt(String str) {
        int mid = (str.length()-1) / 2;
        if (mid > 0) {
            return str.charAt(mid)+
                    decrypt(str.substring(0,mid)) + decrypt(str.substring(mid+1));
        }
        return str;
    }
}
