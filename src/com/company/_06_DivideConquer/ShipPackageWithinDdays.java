package com.company._06_DivideConquer;

public class ShipPackageWithinDdays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }
        while(low < high) {
            int mid = (low+high) / 2;
            int requiredDays = 1;
            int currCap = 0;
            for (int w : weights) {
                if (currCap + w > mid) {
                    currCap = 0;
                    requiredDays++;
                }
                currCap += w;
            }
            if(requiredDays > days) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
