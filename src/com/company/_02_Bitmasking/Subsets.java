package com.company._02_Bitmasking;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        generateSubsets(nums);
    }

    public static void generateSubsets (int[] nums){
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            int n = i;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                if ((n & 1) > 0) {
                    temp.add(num);
                }
                n >>= 1;
            }
            subsets.add(temp);
        }
        System.out.println(subsets);
    }
}
