package com.company.IntroToCollections;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueIntro {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();      //Min-Heap

        int[] nums = {1,8,3,0,2};

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        System.out.println(pq.peek());

        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());     //Max-Heap

        for (int i = 0; i < nums.length; i++) {
            p.add(nums[i]);
        }

        System.out.println(p.peek());
    }
}
