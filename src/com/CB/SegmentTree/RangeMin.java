package com.CB.SegmentTree;

import java.util.Scanner;

public class RangeMin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] nums = {1, 3, 2, -5, 6, 4};
        int n = nums.length;

        Integer[] tree = new Integer[4 * n + 1];

        buildTree(nums,tree,0,n-1,1);

//        int test = s.nextInt();
//        while (test-- > 0){
//            int l = s.nextInt();
//            int r = s.nextInt();
//
//            System.out.println(query(tree, 0, n-1,l,r,1));
//        }
        System.out.println(query(tree, 0, n-1,0,6,1));

        update(tree, 1, 0, n-1, 1, -8);

        System.out.println(query(tree, 0, n-1,2,4,1));
        System.out.println(query(tree, 0, n-1,1,3,1));

    }

    public static void buildTree(int[] nums, Integer[] tree, int start, int end, int index){
        if(start == end){
            tree[index] = nums[start];
            return;
        }

        int mid = (start + end) / 2;
        buildTree(nums,tree,start,mid,2*index);
        buildTree(nums,tree,mid+1,end, 2*index+1);

        tree[index] = Math.min(tree[2*index], tree[2*index+1]);
    }

    public static int query(Integer[] tree, int ts, int te, int qs, int qe, int index){
        //Complete Overlap
        if(ts >= qs && te <= qe){
            return tree[index];
        }

        //No Overlap
        if(qe < ts || qs > te){
            return Integer.MAX_VALUE;
        }

        //Partial Overlap
        int mid = (ts+te)/2;
        int leftAns = query(tree,ts,mid,qs,qe,2*index);
        int rightAns = query(tree,mid+1, te,qs,qe,2*index+1);

        return Math.min(leftAns, rightAns);
    }

    public static void update(Integer[] tree, int index, int ts, int te, int ind, int value) {
        if (ind < ts || ind > te) {
            return;
        }
        if (ts == te) {
            tree[index] = value;
            return;
        }
        int mid = (ts+te)/2;
        update(tree, 2*index+1, mid+1,te, ind, value);
        update(tree, 2*index, ts,mid, ind, value);
        tree[index] = Math.min(tree[2*index], tree[2*index+1]);
    }
}
