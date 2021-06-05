package com.company._03_Recursion;

import java.util.ArrayList;

public class SumTarget {
    public static void main(String[] args) {
        int[] nums = {-1,7,2,-4,3,0,1,-2};
//        sumTarget(nums, 0 ,5 ,0, new ArrayList<>());
//        divideArray(nums, 0, 0, 0, new ArrayList<>(), new ArrayList<>());
        System.out.println(sumTargetList(nums, 0 ,5 ,0, new ArrayList<>()));
    }

    private static void sumTarget(int[] nums, int ind, int target,
                                  int currSum, ArrayList<Integer> list) {
        if (ind == nums.length) {
            if (currSum == target) {
                System.out.println(list);
            }
            return;
        }
        list.add(nums[ind]);
        sumTarget(nums, ind+1, target, currSum+nums[ind],list);
        list.remove(list.size()-1);

        sumTarget(nums, ind+1, target, currSum, list);
    }

    private static ArrayList<ArrayList<Integer>> sumTargetList(int[] nums, int ind, int target,
                                                    int currSum, ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> listNew = new ArrayList<>();
        if (ind == nums.length) {
            if (currSum == target) {
                ArrayList<Integer> temp = new ArrayList<>(list);
                listNew.add(temp);
            }
            return listNew;
        }

        list.add(nums[ind]);
        listNew.addAll(sumTargetList(nums, ind+1, target, currSum+nums[ind],list));
        list.remove(list.size()-1);

        listNew.addAll(sumTargetList(nums, ind+1, target, currSum, list));
        return listNew;
    }

    private static void divideArray(int[] nums, int ind, int sum1, int sum2,
                                    ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if (ind == nums.length) {
            if (sum1 == sum2) {
                System.out.println(list1 + " : " + list2);
            }
            return;
        }
        list1.add(nums[ind]);
        divideArray(nums, ind+1, sum1+nums[ind], sum2,list1, list2);
        list1.remove(list1.size()-1);

        list2.add(nums[ind]);
        divideArray(nums, ind+1, sum1, sum2+nums[ind],list1, list2);
        list2.remove(list2.size()-1);
    }

}
