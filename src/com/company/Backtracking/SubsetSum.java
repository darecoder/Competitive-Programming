package com.company.Backtracking;

import java.util.ArrayList;

public class SubsetSum {
    public static void main(String[] args) {
        int[] nums = {15, 22, 14, 26, 32, 9, 16, 8};
        sumTarget(nums, 0, 53, 0, new ArrayList<>());
    }

    public static void sumTarget(int[] nums, int index, int target,
                                 int sum, ArrayList<Integer> list){
        if(index == nums.length){
            if(sum == target){
                System.out.println(list);
            }
            return;
        }

        list.add(nums[index]);
        sumTarget(nums,index+1,target,sum + nums[index],list);
        list.remove(list.size() - 1);

        sumTarget(nums, index+1,target,sum,list);
    }
}
