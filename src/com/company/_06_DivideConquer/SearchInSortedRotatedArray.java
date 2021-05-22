package com.company._06_DivideConquer;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;
        System.out.println(searchRotatedArray(nums, target));
    }

    public static int searchRotatedArray(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int lo = 0, high = nums.length-1;
        while (lo <= high) {
            int mid = (lo + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[lo]) {
                if (target < nums[mid] && target >= nums[lo]) {
                    high = mid-1;
                } else {
                    lo = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    lo = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
