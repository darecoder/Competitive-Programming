package com.company._08_SlidingWindow;

public class MaxSumKEltsCornerElts {
    // Question Link : https://www.geeksforgeeks.org/maximize-sum-of-k-elements-in-array-by-taking-only-corner-elements/
    public static void main(String[] args) {
        int[] arr = {8, 4, 4, 8, 12, 3, 2, 9};
        int K = 3;
        int n = arr.length;
        System.out.print(maxPointCount(arr, K, n));
    }

    // Function to return maximum sum
    public static int maxPointCount(int[] arr, int K, int size) {
        // Initialise variables
        int currPoints = 0;
        int maxPoints = 0;

        // Iterate over first K elements
        // of array and update the value
        // for currPoints
        for (int i = 0; i < K; i++) {
            currPoints += arr[i];
        }

        // Update value for maxPoints
        maxPoints = currPoints;

        // j points to the end of the array
        int j = size - 1;
        for (int i = K - 1; i >= 0; i--) {
            currPoints = currPoints + arr[j] - arr[i];
            maxPoints = Math.max(currPoints, maxPoints);
            j--;
        }
        // Return the final result
        return maxPoints;
    }
}