package com.CB.Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Trie{
    class Node{
        char data;
        boolean terminal;
        Map<Character, Node> children = new HashMap<>();

        public Node(char data) {
            this.data = data;
            this.terminal = false;
        }
    }

    Node root;
    int count;

    Trie(){
        this.root = new Node('\0');
        this.count = 0;
    }

    public void addWord(String str){
        Node temp = this.root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(temp.children.containsKey(ch)){
                temp = temp.children.get(ch);
            }else {
                Node n = new Node(ch);
                temp.children.put(ch, n);
                temp = n;
            }
        }

        temp.terminal = true;
    }

    public boolean search(String str){
        Node temp = this.root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (temp.children.containsKey(ch)){
                temp = temp.children.get(ch);
            }else {
                return false;
            }
        }

        return temp.terminal;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Trie trie = new Trie();
        System.out.print("No. of words you want to add : ");
        int n = s.nextInt();

        System.out.print("Enter the words : ");
        while (n-- > 0){
            String str = s.next();
            trie.addWord(str);
        }

        System.out.print("Enter the no. of queries : ");
        int q = s.nextInt();

        System.out.print("Enter the queries : ");
        while (q-- > 0){
            String str = s.next();
            System.out.println(trie.search(str));
        }
    }
}


