package com.company._06_DivideConquer;

public class PainterPartition {
    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int painters = 2;
        System.out.println(partition(boards, boards.length, painters));
    }

    public static int partition(int[] nums, int n, int k) {
        int lo = 0, hi = 0;
        for (int num : nums) {
            lo = Math.max(lo, num);
            hi += num;
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int requiredPainters = 1, currTotal = 0;
            for (int i = 0; i < n; i++) {
                currTotal += nums[i];
                if (currTotal > mid) {
                    currTotal = nums[i];
                    requiredPainters++;
                }
            }
            if (requiredPainters <= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
