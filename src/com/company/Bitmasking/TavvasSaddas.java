package com.company.Bitmasking;

import java.util.Scanner;

public class TavvasSaddas {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        String num = s.nextLine();
        int len = num.length();

        int ans = (1 << len) - 2;   // 2^0 + 2^1 + 2^3 + 2^4 ... = 2(2^len-1 - 2)/2-1

        for (int i = len-1; i >= 0; i--) {
            int pos = len - i - 1;
             if(num.charAt(i) == '7'){
                ans += (1 << pos);
            }
        }

        System.out.println(ans+1);
    }
}
