package com.company._06_DivideConquer;

public class ShipPackageWithinDdays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        //Minimum shipping capacity required is the maximum weight package
        // which means if we'll ship all the packages individually
        //Maximum shipping capacity required is the sum of all packages
        // which means we will ship all the packages in one go.
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }
        while(low < high) {
            int mid = (low+high) / 2;
            //initially we will assume if we ship everything in one day
            int requiredDays = 1;
            int currCap = 0;
            for (int w : weights) {
                //if in the current shipment we will add one more package
                // and it becomes greater than the worse, initialize currCap = 0 and
                // increase the no of required days such that we'll ship this in another shipment
                if (currCap + w > mid) {
                    currCap = 0;
                    requiredDays++;
                }
                currCap += w;
            }
            //if the required days we assumed is more than what was given,
            // we'll have to increase the weights we are shipping in each shipment.
            // Hence increase the low.
            if(requiredDays > days) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
