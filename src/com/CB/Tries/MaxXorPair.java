package com.CB.Tries;

import java.util.Scanner;

class Tries{
    private class Node{
        Node left;      //Represents '0'
        Node right;     //Represents '1'
    }

    Node root;

    Tries(){
        this.root = new Node();
    }

    public void addWord(int n){
        Node curr = root;

        /*
        Convert the number into binary and add to the trie
         */
        for (int i = 31; i >= 0; i--) {
            int bit =  (n >> i) & 1;
            if (bit == 0){
                // If current bit is '0' , move to left child
                if (curr.left == null) {
                    curr.left = new Node();
                }
                curr = curr.left;
            }else {
                // If current bit is '1' , move to right child
                if (curr.right == null) {
                    curr.right = new Node();
                }
                curr = curr.right;
            }
        }
    }

    public int maxXorPair(int elt) {
        Node curr = root;
        int currXor = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (elt >> i) & 1;
            if (bit == 0){
                //Current bit is '0' for the gievn number
                if (curr.right != null){
                    // and we get '1' in trie we will add Xor value for current bit
                    curr = curr.right;
                    currXor += (int)Math.pow(2,i);
                }else {
                    curr = curr.left;
                }
            }else {
                //Current bit is '1'
                if (curr.left != null){
                    // and we get '0' in trie we will add Xor value for current bit
                    curr = curr.left;
                    currXor += (int)Math.pow(2,i);
                }else {
                    curr = curr.right;
                }
            }
        }
        return currXor;
    }

}

public class MaxXorPair {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Tries trie = new Tries();
        int[] nums = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
            trie.addWord(nums[i]);
            int x = trie.maxXorPair(nums[i]);
            result = Math.max(result, x);
        }

        System.out.println(result);
    }
}
