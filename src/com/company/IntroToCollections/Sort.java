package com.company.IntroToCollections;

import java.util.Arrays;
import java.util.Collections;

public class Sort {
    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 2, 9, 0, 3, 6, 8, 5};   //Original Array

        Arrays.sort(nums);  //In-built Sort funcction

        System.out.println(Arrays.toString(nums));  //To print the array

        Integer[] arr = {1, 4, 7, 2, 9, 0, 3, 6, 8, 5};

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(Arrays.toString(arr));  //To print the array in reverse order
    }
}
