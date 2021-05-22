package com.company._09_PigeonHolePrinciple;

import java.util.Arrays;

public class MaximumGapLeetcode {
    public static void main(String[] args) {
        int[] nums = {1,9,3,6,18};
        System.out.println(maximumGap(nums));
    }

    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
           min = Math.min(min, num);
           max = Math.max(max, num);
        }
        int avgInterval = (int)Math.ceil(1.0*(max-min)/(nums.length-1));
        int[] bucketMin = new int[nums.length-1];
        int[] bucketMax = new int[nums.length-1];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int num : nums) {
            if (num == max || num == min) {
                continue;
            }
            int ind = (num-min) / avgInterval;
            bucketMin[ind] = Math.min(bucketMin[ind], num);
            bucketMax[ind] = Math.max(bucketMax[ind], num);
        }

        int maxGap = 0, prev = min;
        for (int i = 0; i < bucketMax.length; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            int gap = bucketMin[i] - prev;
            maxGap = Math.max(gap, maxGap);
            prev = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max-prev);
        return maxGap;
    }
}
