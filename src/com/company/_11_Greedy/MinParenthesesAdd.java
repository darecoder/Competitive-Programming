package com.company._11_Greedy;

import java.util.Stack;

public class MinParenthesesAdd {
    public static void main(String[] args) {
        String str = "()))((";
        System.out.println(minAddToMakeValid(str));
    }

    public static int minAddToMakeValid(String str) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> inValid = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    inValid.push(')');
                }
            }
        }
        return (stack.size() + inValid.size());
    }
}
