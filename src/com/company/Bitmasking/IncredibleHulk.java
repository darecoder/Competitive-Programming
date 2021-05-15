package com.company.Bitmasking;

public class IncredibleHulk {
    public static void main(String[] args) {
        System.out.println(countOne(5));
    }

    public static int countOne(int n){
        int cnt = 0;
        while(n > 0){
            if((n & 1) == 1) {
                cnt++;
            }
            n = n >>1;
        }
        return cnt;
    }
}