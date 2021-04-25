package com.company.IntroToCollections;

import java.util.Scanner;

public class PriorityCar {
    static long M = 1000000007;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int r = s.nextInt();
            int p = s.nextInt();
            long A = 0;
            long S = 0;
            System.out.println(1 + countWays(r,p,A,S));
        }
    }

    public static long countWays(int r, int p, long A, long S){
        if (r == 0){
            return 0;
        }
        long ways;
        if (A >= p*(S+1)){
            ways = 1 + countWays(r-1,p,A+1,S) + countWays(r-1,p,A,S+1);
        }else {
            ways = countWays(r-1,p,A+1,S);
        }
        return ways % M;
    }
}
