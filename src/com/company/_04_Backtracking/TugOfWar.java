package com.company._04_Backtracking;

public class TugOfWar {
    public static int min_diff;
    public static void main (String[] args) {
        int[] nums = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        boolean[] curr_elements = new boolean[nums.length];
        boolean[] soln = new boolean[nums.length];
        min_diff = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        tugOfWar(nums, curr_elements, 0, soln, sum, 0, 0);
        printSolution(soln, nums);
    }

    public static void tugOfWar(int[] nums, boolean[] curr_elements, int selected,
                                boolean[] soln, int sum, int currSum, int pos) {
        if (pos == nums.length || selected > (nums.length+1)/2) {
            return;
        }
        tugOfWar(nums, curr_elements, selected, soln, sum, currSum, pos+1);
        selected++;
        currSum = currSum + nums[pos];
        curr_elements[pos] = true;
        if (selected == nums.length / 2) {
            if (Math.abs(sum / 2 - currSum) < min_diff) {
                min_diff = Math.abs(sum / 2 - currSum);
                System.arraycopy(curr_elements, 0, soln, 0, curr_elements.length);
            }
        } else {
            tugOfWar(nums, curr_elements, selected, soln, sum, currSum, pos + 1);
        }
        curr_elements[pos] = false;
    }

    public static void printSolution(boolean[] soln, int[] arr) {
        System.out.print("The first subset is: ");
        for (int i = 0; i < soln.length; i++) {
            if (soln[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.print("\nThe second subset is: ");
        for (int i = 0; i < soln.length; i++) {
            if (!soln[i]) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
