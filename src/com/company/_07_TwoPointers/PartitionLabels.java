package com.company._07_TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(str));
    }

    public static List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] freqMap = new int[26];

        for(int i = 0; i < S.length(); i++){
            freqMap[S.charAt(i)-'a'] = i;
        }
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, freqMap[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
