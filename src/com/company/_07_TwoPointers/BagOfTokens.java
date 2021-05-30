package com.company._07_TwoPointers;

import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {
        int[] tokens = {100,200,300,400};
        int power = 200;
        System.out.println(bagOfTokensScore(tokens, power));
    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        Arrays.sort(tokens);
        if(tokens.length == 0 || tokens[0] > power) {
            return score;
        }
        int left = 0,right = tokens.length-1;
        int tempScore = 0;
        while(left <= right){
            if(tokens[left] <= power){
                tempScore++;
                power-=tokens[left++];
            }else{
                power+=tokens[right--];
                tempScore--;
            }
            score = Math.max(tempScore,score);
        }
        return score;
    }
}
