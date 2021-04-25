package com.company.IntroToCollections;

import java.util.Stack;

public class StackIntro {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();

        st.push("Apple");
        st.push("Mango");
        st.push("Orange");

        System.out.println(st.pop());
    }
}
