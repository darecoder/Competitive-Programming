package com.company.Bitmasking;

import java.util.ArrayList;

public class SubsetsBitmasking {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        generateSubsets(nums);
    }

    public static void generateSubsets (int[] nums){
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            int t = i;
            ArrayList<Integer> v = new ArrayList<>();
            for (int num : nums) {
                if ((t & 1) > 0) {
                    v.add(num);
                }
                t >>= 1;
            }
            subsets.add(v);
        }
        System.out.println(subsets);
    }
}
