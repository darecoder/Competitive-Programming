package com.company._08_SlidingWindow;

public class MaxSumKEltsCornerElts {
    // Driver code : https://www.geeksforgeeks.org/maximize-sum-of-k-elements-in-array-by-taking-only-corner-elements/
    public static void main(String[] args) {
        int[] arr = {8, 4, 4, 8, 12, 3, 2, 9};
        int K = 3;
        int n = arr.length;
        System.out.print(maxPointCount(arr, K, n));
    }

    // Function to return maximum sum
    public static int maxPointCount(int[] arr, int K, int size) {
        // Initialse variables
        int curr_points = 0;
        int max_points = 0;

        // Iterate over first K elements
        // of array and update the value
        // for curr_points
        for (int i = 0; i < K; i++) {
            curr_points += arr[i];
        }

        // Update value for max_points
        max_points = curr_points;

        // j points to the end of the array
        int j = size - 1;
        for (int i = K - 1; i >= 0; i--) {
            curr_points = curr_points + arr[j] - arr[i];
            max_points = Math.max(curr_points, max_points);
            j--;
        }
        // Return the final result
        return max_points;
    }
}