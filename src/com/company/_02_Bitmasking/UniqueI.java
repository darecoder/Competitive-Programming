package com.company._02_Bitmasking;

public class UniqueI {
    public static void main(String[] args) {
        int[] nums = {4,9,2,7,4,2,7};
        int unique = 0;

        for (int i = 0; i < nums.length; i++) {
            unique = unique ^ nums[i];
        }

        System.out.println(unique);
    }
}
