package com.company._04_Backtracking;

import java.util.Collections;
import java.util.HashSet;

public class WordBreak {
    public static void main(String[] args) {
        String str = "iloveicecreamandmango";
        String[] strings = {"man", "i", "like", "ice", "and", "cream", "sam", "sung",
                "samsung", "mobile", "icecream", "mango", "love"};
        HashSet<String> dictionary = new HashSet<>();
        Collections.addAll(dictionary, strings);
        wordBreak(str, "", dictionary);
    }

    public static void wordBreak(String str, String result, HashSet<String> dictionary) {
        if (str.isEmpty()) {
            System.out.println(result);
            return;
        }
        for (int i=1; i<=str.length(); i++) {
            String prefix = str.substring(0, i);
            if (dictionary.contains(prefix)) {
                wordBreak(str.substring(i),
                        result + prefix + " ", dictionary);
            }
        }
    }


}
