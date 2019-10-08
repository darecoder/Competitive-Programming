package com.CB.IntroToCollections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueIntro {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(3);
        q.add(8);
        q.add(5);
        q.add(2);

        while (!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
